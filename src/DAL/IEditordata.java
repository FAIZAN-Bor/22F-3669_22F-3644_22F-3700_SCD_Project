package DAL;

import java.util.ArrayList;
import java.util.List;

import DTO.Files;
import DTO.Page;

public interface IEditordata {
	List<Files> getFiles();
	boolean saveToDB(String title, String content);
	String generateHash(String content);
	List<String> splitContentIntoPages(String content, int wordsPerPage);
	boolean updateFilename(int id, String newTitle);
	boolean deleteFilename(int id);
	String viewFilename(int id);
	Files searchFile(String title);
	List<Page> searchWordfromFiles(String word, String option);
	ArrayList<Page> navigatefromdb(int id);
}
