package BLL;
import com.ibm.icu.text.Transliterator;
import com.qcri.farasa.segmenter.Farasa;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
<<<<<<< HEAD
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
=======

>>>>>>> 8a106d5f0b94c5f9bee90172bcfce7741e348541

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
