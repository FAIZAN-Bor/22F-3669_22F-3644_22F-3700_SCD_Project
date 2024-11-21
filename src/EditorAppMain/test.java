package EditorAppMain;
import java.util.List;
import java.util.ArrayList;
import org.tartarus.snowball.ext.arabicStemmer;

public class test {
	public static List<String> splitArabicDocumentsIntoWords(String document) {
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
    public static void main(String[] args) {
        List<String> s=new ArrayList<>();
        s.add("أنا أحب قراءة الكتب في أوقات الفراغ");
        s.add("الطقس اليوم مشمس وجميل جدًا");
        s.add("التعلم المستمر هو مفتاح النجاح في الحياة");
        String result = String.join(" ", s);
        System.out.println(result);
        s=splitArabicDocumentsIntoWords(result);
        System.out.println(s);
        
    }
}
