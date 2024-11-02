package DTO;

public class Files {
	private int id;
	private String filename;
	private String content;
	
	public Files(int id, String filename, String content) {
		this.id=id;
		this.filename=filename;
		this.content=content;
	}
	public int getid()
	{
		return id;
	}
	public String getfilename()
	{
		return filename;
	}
	public String getcontent()
	{
		return content;
	}
}
