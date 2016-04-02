public class Book{
	private String id;
	private String title;
	private String author;
	private String year;
	private String type;
	
	public Book(String id, String title, String author, String year, String type){
	/********************************************************************************************
		The constructor of a Book.
	********************************************************************************************/
		this.id=id;
		this.title=title;
		this.author=author;
		this.year=year;
		this.type=type;
	
	}
	
	
	public String getId(){
		return this.id;
	}
	
	public String getTitle(){
		return this.title;
	}
	public String getAuthor(){
		return this.author;
	}
	public String getYear(){
		return this.year;
	}
	public String getType(){
		return this.type;
	}
	
	public void setId(String iD){
		this.id = iD;
	}
	
	

}
