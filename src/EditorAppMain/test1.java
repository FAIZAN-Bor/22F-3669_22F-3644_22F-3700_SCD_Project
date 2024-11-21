package EditorAppMain; 

import java.util.ArrayList;
import java.util.List;

import net.oujda_nlp_team.AlKhalil2Analyzer;
import net.oujda_nlp_team.entity.Result;

public class test1 {

    private AlKhalil2Analyzer analyzer;

    public test1() throws Exception {
        analyzer = AlKhalil2Analyzer.getInstance();
    }

    public List<String[]> lemmatizeWords(List<String> words) {
        List<String[]> lemmatizedWords = new ArrayList<>();
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

    public static void main(String[] args) throws Exception {
        test1 lemmatization = new test1();

        // Example words
        List<String> words = List.of("كتبوا", "كتبت", "الكتاب");

        // Get lemmas
        List<String[]> lemmatized = lemmatization.lemmatizeWords(words);
        lemmatized.forEach(entry -> System.out.println(entry[0] + " -> " + entry[1]));
    }
}
