

import java.util.ArrayList;

public class User{
	private String name;
	private String username;
	private String password;
	private ArrayList<Book> borrowedBooks;
	
	public User(String name, String username, String password){
		this.name = name;
		this.username=username;
		this.password=password;
		borrowedBooks = new ArrayList<Book>();
	}

	public String getName(){
		return this.name;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	

public void borrowBook(HashMap<String,ArrayList<Book>> book){
		Scanner sc  = new Scanner(System.in);
		String bookToBorrow;
		int i;
		Book a;
		System.out.print("What book do you want to borrow? ");
		bookToBorrow = sc.nextLine();
		Iterator bookItr; 
		if(book.contains(bookToBorrow)){
			System.out.println("Book found!");
			ArrayList<Book> b = book.get(bookToBorrow);
			for(i = 0; i < b.size(); i++){
				System.out.println(i + 
					" Title: " + b.get(i).getTitle() + 
					" Author: " + b.get(i).getAuthor() + 
					" Year: " + b.get(i).getYear()) +
					" ID: " + b.get(i).getID());


				}
			System.out.println("Enter choice: ");
			i = sc.nextInt();
			a = b.get(i);
			book.removeBook(a);
			this.borrowedBooks.add(a);
			}
			else{
				System.out.println("Book not available.");
			}

		

	}



	public void returnBook(HashMap<String,ArrayList<Books>> book){
		String bookToReturn;
		int i;
		Iterator bookItr;
		for(i = 0; i < this.borrowedBooks.size(); i++){
			System.out.println(i +
			" Title: " + borrowedBooks.get(i).getTitle() + 
			" Author: " + borrowedBooks.get(i).getAuthor() + 
			" Year: " + borrowedBooks.get(i).getYear()) +
			" ID: " + borrowedBooks.get(i).getID());
		}
		
		System.out.println("Enter choice: ");
		i = sc.nextInt();
		Book a = borrowedBooks.get(i);
		this.borrowedBooks.remove(i);
		book.addBook(a);



	public void viewBooksBorrowed(){
		Iterator booksIterator = borrowedBooks.iterator();
		while(booksIterator.hasNext()){
			System.out.println(booksIterator.next().getTitle());
		}

	}
