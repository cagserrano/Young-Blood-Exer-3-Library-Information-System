import java.util.ArrayList;

public class User{
	private String name;
	private ArrayList<Book> borrowedBooks;
	
	public User(String name){
		this.name = name;
		borrowedBooks = new ArrayList<Book>();
	}
}
