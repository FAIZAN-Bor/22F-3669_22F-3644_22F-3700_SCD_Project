package BLL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import DTO.Files;
import DTO.Page;

public interface IEditorBusinessLogic {
	List<Files> getFiles();
	boolean saveToDB(String filename, String content);
	boolean updateFilename(int id, String newFilename);
	boolean deleteFile(int id);
	String viewFile(int id);
	String readFile(File filename);
	Files searchFilename(String filename);
	List<Page> searchWordFromFiles(String word, String selectedOption);
	String generateSnippet(String contentLine, String word);
	String transliterate(String data);
	ArrayList<String> navigatepages(int name);
	List<String> ArabictoMorphemes(String text);
	List<String> userSelectedorFilecontent(String filecontent, String selectedText);
	List<String[]> tagWordsWithPOS(List<String> words);
	List<String[]> generateStemming(List<String> words);
<<<<<<< HEAD
	List<String[]> lemmatizeWords(List<String> words);
=======
>>>>>>> 8a106d5f0b94c5f9bee90172bcfce7741e348541
}
