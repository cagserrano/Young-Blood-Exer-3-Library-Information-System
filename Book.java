public class Book{
	private String ID;
	private String title;
	private String author;
	private String year;
	private String type;
	
	public Book(String ID, String title, String author, String year, String type){
		this.ID=ID;
		this.title=title;
		this.author=author;
		this.year=year;
		this.type=type;
	
	}
	
	
	public String getId(){
		return this.ID;
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
	public String type(){
		return this.type;
	}
	
	

}