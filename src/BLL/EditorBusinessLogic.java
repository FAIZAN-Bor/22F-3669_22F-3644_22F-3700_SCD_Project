package BLL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import DAL.Editordata;
import DAL.IEditordata;
import DTO.Files;
import DTO.Page;

public class EditorBusinessLogic implements IEditorBusinessLogic{
//    private Editordata data = new Editordata();
	private IEditordata data;
	public EditorBusinessLogic(IEditordata data)
	{
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
    public List<Page> searchWordFromFiles(String word)
    {
    	return data.searchWordfromFiles(word);
    }
    public Files searchFilename(String filename) {
        return data.searchFile(filename);
    }
    public String generateSnippet(String contentLine, String word) {
        int index = contentLine.toLowerCase().indexOf(word.toLowerCase());
        if (index != -1) {
            int start = Math.max(0, index - 15);
            int end = Math.min(contentLine.length(), index + word.length() + 15);
            return contentLine.substring(start, end) + "...";
        }
        return contentLine;  // Return the full content if word not found
    }
}
