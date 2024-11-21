package BLL;
import com.ibm.icu.text.Transliterator;
import com.qcri.farasa.segmenter.Farasa;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.tartarus.snowball.ext.arabicStemmer;

import DAL.Editordata;
import DAL.IEditordata;
import DTO.Files;
import DTO.Page;
import net.oujda_nlp_team.AlKhalil2Analyzer;
import net.oujda_nlp_team.entity.Result;

public class EditorBusinessLogic implements IEditorBusinessLogic{
//    private Editordata data = new Editordata();
	private IEditordata data;
	private Farasa farasaSegmenter;
	
	public EditorBusinessLogic(IEditordata data) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		this.farasaSegmenter=new Farasa();
		this.data=data;
	}
    public List<Files> getFiles() {
        return data.getFiles();
    }
    public List<String> getfilescontent()
    {
    	List<String> documents=new ArrayList<>();
    	documents=data.getAllFilescontent();
		return documents;
    	
    }
    public boolean saveToDB(String filename, String content) {
        return data.saveToDB(filename, content);
    }

    public boolean updateFilename(int id, String newFilename) {
        return data.updateFilename(id, newFilename);
    }

    public boolean deleteFile(int id) {
        return data.deleteFilename(id);
    }

    public String viewFile(int id) {
        return data.viewFilename(id);
    }

    public String readFile(File filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    public List<Page> searchWordFromFiles(String word,String option)
    {
    	return data.searchWordfromFiles(word,option);
    }
    public Files searchFilename(String filename) {
        return data.searchFile(filename);
    }
    public String generateSnippet(String contentLine, String word) {
        int index = contentLine.indexOf(word);
        if (index != -1) {
            int start = Math.max(0, index - 15);
            int end = Math.min(contentLine.length(), index + word.length() + 15);
            return contentLine.substring(start, end) + "...";
        }
        return contentLine;  // Return the full content if word not found
    }
    public List<String> splitArabicDocumentsIntoWords(String document) {
        if (document == null || document.trim().isEmpty()) {
            throw new IllegalArgumentException("The document cannot be null or empty.");
        }

        // Clean the text to remove non-Arabic characters (punctuation, numbers, etc.)
        String cleanedDocument = document.replaceAll("[^\\p{IsArabic}\\s]", "").trim();

        // Split the cleaned document into words based on whitespace
        String[] wordsArray = cleanedDocument.split("\\s+");

        // Convert the array to a list
        List<String> words = new ArrayList<>();
        for (String word : wordsArray) {
            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        return words;
    }
    @Override
    public List<String> ArabictoMorphemes(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        try {
            String cleanedText = text.replaceAll("[^\\p{IsArabic}\\s]", "").trim();

            List<String> segmentedWords = farasaSegmenter.segmentLine(cleanedText);

            return segmentedWords.stream()
                                 .filter(word -> word != null && !word.trim().isEmpty())
                                 .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error during Farasa segmentation", e);
        }
    }

    @Override
    public List<String> userSelectedorFilecontent(String filecontent, String selectedText) {
        String textToSegment;
        if (selectedText != null && !selectedText.trim().isEmpty()) {
            textToSegment = selectedText;
        } else {
        	textToSegment=filecontent;
        }
        return ArabictoMorphemes(textToSegment);
    }
    
    @Override
    public List<String[]> tagWordsWithPOS(List<String> words) {
        List<String[]> wordDetails = new ArrayList<>();
        AlKhalil2Analyzer analyzer = AlKhalil2Analyzer.getInstance();

        for (String word : words) {
            try {
                List<Result> results = analyzer.processToken(word).getAllResults();
                String posTags = results.isEmpty() ? "Unknown" : String.join(", ", results.get(0).getPartOfSpeech().split("\\|"));

                wordDetails.add(new String[]{word, posTags});
            } catch (Exception e) {
                wordDetails.add(new String[]{word, "Error"});
            }
        }

        return wordDetails;
    }
    @Override
    public List<String[]> generateStemming(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("The input list of words cannot be null or empty.");
        }

        // Create an instance of the Arabic stemmer
        arabicStemmer stemmer = new arabicStemmer();

        // List to store the original word and its stemmed version
        List<String[]> stemmedWords = new ArrayList<>();

        // Stem each word in the list
        for (String word : words) {
            if (word != null && !word.trim().isEmpty()) {
                stemmer.setCurrent(word); // Set the current word to the stemmer
                String stemmedWord = stemmer.stem() ? stemmer.getCurrent() : word; // Stem or retain original
                stemmedWords.add(new String[]{word, stemmedWord}); // Add both original and stemmed word
            }
        }

        return stemmedWords;
    }
    public Map<String, Double> calculateTF(List<String> documentWords, List<String> selectedWords) {
        if (documentWords == null || selectedWords == null) {
            throw new IllegalArgumentException("Input lists cannot be null.");
        }

        Map<String, Integer> wordCount = new HashMap<>();
        int totalWords = documentWords.size();

        if (totalWords == 0) {
            throw new IllegalArgumentException("The document must contain at least one word.");
        }

        // Count word occurrences in the document for selected words
        for (String word : documentWords) {
            if (selectedWords.contains(word)) { // Only count selected words
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        // Calculate term frequency (TF) for selected words
        Map<String, Double> tf = new HashMap<>();
        for (String word : selectedWords) {
            int count = wordCount.getOrDefault(word, 0);
            tf.put(word, (double) count / totalWords); // Term Frequency = word count / total words
        }

        return tf;
    }
    public Map<String, Double> calculateCorpusProbability(List<String> corpusWords, List<String> wordsToCheck) {
        Map<String, Integer> wordCount = new HashMap<>();
        int totalWords = corpusWords.size();

        // Count frequencies of all words in the corpus
        for (String word : corpusWords) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Calculate corpus probability for the given words
        Map<String, Double> probabilitiess = new HashMap<>();
        for (String word : wordsToCheck) {
            int frequency = wordCount.getOrDefault(word, 0);
            probabilitiess.put(word, (double) frequency / totalWords);
        }

        return probabilitiess;
    }
    public List<String[]> calculatePKL(Map<String, Double> tf, Map<String, Double> corpusProbability) {
        List<String[]> pklList = new ArrayList<>();

        for (String word : tf.keySet()) {
            double tfValue = tf.get(word);
            double corpusProb = corpusProbability.getOrDefault(word, 1e-10); // Avoid division by zero

            // Calculate PKL score
            double pkl = tfValue * Math.log(tfValue / corpusProb);
            pkl=Math.abs(pkl);

            // Add the word and its PKL score to the list as an array
            pklList.add(new String[]{word, String.valueOf(pkl)});
        }

        return pklList;
    }

    public Map<String, Double> calculateIDF(List<String> documents, List<String> selectedWords) {
        Map<String, Integer> docCount = new HashMap<>();
        int totalDocs = documents.size();

        // Count documents containing each selected word
        for (String doc : documents) {
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(doc.split(" ")));
            for (String word : selectedWords) {
                if (uniqueWords.contains(word)) {
                    docCount.put(word, docCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        
        // Calculate IDF for each selected word
        Map<String, Double> idf = new HashMap<>();
        for (String word : selectedWords) {
            int count = docCount.getOrDefault(word, 0);
            double idfValue = (count > 0) ? Math.log((double) totalDocs / count) : 0.0;
            idf.put(word, idfValue);
        }

        return idf;
    }
    public List<String[]> calculateTFIDF(Map<String, Double> tfScores, Map<String, Double> idfScores) {
        List<String[]> tfidfScoresList = new ArrayList<>();

        for (String word : tfScores.keySet()) {
            double tf = tfScores.getOrDefault(word, 0.0);
            double idf = idfScores.getOrDefault(word, 0.0);
            double tfidf = tf * idf;

            // Add word, TF, and TF-IDF as an array to the list
            tfidfScoresList.add(new String[] { word, String.valueOf(tf), String.valueOf(tfidf) });
        }

        return tfidfScoresList;
    }
    public List<String[]> calculatePMI(List<String> segmentedWords) {
        Map<String, Integer> wordFreq = new HashMap<>();
        Map<String, Integer> cooccurrence = new HashMap<>();
        int totalWords = segmentedWords.size();
        int totalPairs = 0;

        // Step 1: Count word frequencies and co-occurrences
        for (int i = 0; i < segmentedWords.size(); i++) {
            // Increment word frequency
            String word = segmentedWords.get(i);
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);

            // Check co-occurrence within a fixed window (e.g., ±1 word)
            for (int j = i + 1; j < Math.min(i + 2, segmentedWords.size()); j++) {
                String word2 = segmentedWords.get(j);
                String pair = word + "," + word2;

                cooccurrence.put(pair, cooccurrence.getOrDefault(pair, 0) + 1);
                totalPairs++;
            }
        }

        // Step 2: Calculate PMI and store in List<String[]>
        List<String[]> pmiScores = new ArrayList<>();
        for (String pair : cooccurrence.keySet()) {
            String[] words = pair.split(",");
            String word1 = words[0];
            String word2 = words[1];

            double pWord1 = (double) wordFreq.get(word1) / totalWords;
            double pWord2 = (double) wordFreq.get(word2) / totalWords;
            double pWordPair = (double) cooccurrence.get(pair) / totalPairs;

            double pmi = Math.log(pWordPair / (pWord1 * pWord2));

            // Add to the result as a String array with the required format
            pmiScores.add(new String[]{"(" + word1 + "," + word2 + ")", String.valueOf(pmi)});
        }

        return pmiScores;
    }

    @Override
    public List<String[]> lemmatizeWords(List<String> words) {
        List<String[]> lemmatizedWords = new ArrayList<>();
        AlKhalil2Analyzer analyzer = AlKhalil2Analyzer.getInstance();
        for (String word : words) {
            try {
                List<Result> results = analyzer.processToken(word).getAllResults();
                String lemma = results.isEmpty() ? "Unknown" : results.get(0).getLemma();
                lemmatizedWords.add(new String[]{word, lemma});
            } catch (Exception e) {
                lemmatizedWords.add(new String[]{word, "Error"});
            }
        }
        return lemmatizedWords;
    }

    @Override
    public ArrayList<String> navigatepages(int name) {
		// TODO Auto-generated method stub
		ArrayList<Page>pages=new ArrayList<>();
		pages=data.navigatefromdb(name);
		ArrayList<String> result = new ArrayList<>();
		
		if (pages.isEmpty()) {
			return null;
		}
		else {
			for(Page f: pages){
				result.add(f.getSearchResult());
			}
			
		}
		return result;
	}
	@Override
	public String transliterate(String arabicText) {
		// TODO Auto-generated method stub
		

		String rules = "\u0636 > d; "
                + "\u0623 > a; "
                + "\u0625 > i; "
                + "\u0627 > a; "
                + "\u0628 > b; "
                + "\u062A > t; "
                + "\u062B > th; "
                + "\u062C > j; "

                + "\u062D > h; "
                + "\u062E > kh; "
                + "\u062F > d; "
                + "\u0631 > r; "
                + "\u0632 > z; "
                + "\u0633 > s; "
                + "\u0634 > sh; "
                + "\u0635 > s; "
                + "\u0637 > t; "
                + "\u0638 > dh; "
                + "\u0639 > a; "
                + "\u063A > gh; "
                + "\u0641 > f; "
                + "\u0642 > q; "
                + "\u0643 > k; "
                + "\u0644 > l; "
                + "\u0645 > m; "
                + "\u0646 > n; "
                + "\u0647 > h; "
                + "\u0648 > w; "
                + "\u064A > y; "
                + "\u0629 > h;";
		
		   Transliterator transliterator = Transliterator.createFromRules("ArabicToEnglish", rules, Transliterator.FORWARD);
		   
		   return transliterator.transliterate(arabicText);
	}
	
	
	
}
