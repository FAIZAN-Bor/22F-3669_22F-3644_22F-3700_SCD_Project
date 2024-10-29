package BLL;

import java.io.File;
import java.util.List;

import DTO.Files;

public interface IEditorBusinessLogic {
	List<Files> getFiles();
	boolean saveToDB(String filename, String content);
	boolean updateFilename(int id, String newFilename);
	boolean deleteFile(int id);
	String viewFile(int id);
	String readFile(File filename);
	Files searchFilename(String filename);
}
