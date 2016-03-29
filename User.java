import java.util.ArrayList;

public class User{
	private String name;
	private ArrayList<Book> borrowedBooks;
	
	public User(String name){
		this.name = name;
		borrowedBooks = new ArrayList<Book>();
	}

	public void borrowBook(ArrayList<Book> books){
		Scanner sc  = new Scanner(System.in);
		String bookToBorrow;
		int i;
		bookToBorrow = sc.nextLine();

		for(i = 0; i < books.length; i++){
			if(bookToBorrow == books[i]){
				System.out.println("Book found!");
				this.borrowedBooks.add(Book books[i]);
				books.remove(i);
				break;
			}
			else{
				System.out.println("Book not available.");
			}

		}

	}

}
