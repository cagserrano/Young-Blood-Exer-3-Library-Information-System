import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class User{
	private String name;
	private String username;
	private String password;
	private ArrayList<Book> borrowedBooks;
	
	public User(String name, String username, String password){
	/********************************************************************************************
		The constructor of a User.
	********************************************************************************************/
		this.name = name;
		this.username=username;
		this.password=password;
		borrowedBooks = new ArrayList<Book>();
	}

	public String getName(){
	/********************************************************************************************
		This method returns the name of the user.
	********************************************************************************************/
		return this.name;
	}
	
	public String getUsername(){
	/********************************************************************************************
		This method returns the username of the user.
	********************************************************************************************/
		return this.username;
	}
	
	public String getPassword(){
	/********************************************************************************************
		This method returns the password of the user.
	********************************************************************************************/
		return this.password;
	}
	

	public void borrowBook(Library l){
	/********************************************************************************************
		This method allows the user to borrow a book from the library.
		It adds the book borrowed to the user's arraylist of books.
		It removes the book borrowed from the library's arraylist of books.
	********************************************************************************************/
		Scanner sc  = new Scanner(System.in);
		String bookToBorrow;
		int i;
		Book a;
		System.out.print("\n\t\tWhat book do you want to borrow? ");
		bookToBorrow = sc.nextLine();
		Iterator bookItr; 
		HashMap<String, ArrayList<Book>> book = l.getBookMap();
		if(book.containsKey(bookToBorrow)){
			System.out.println("\n\t\tBook found!\n");
			ArrayList<Book> b = book.get(bookToBorrow);
			for(i = 0; i < b.size(); i++){
				System.out.println("\t\t[" + i + "]" + 
					"	Title: " + b.get(i).getTitle() + 
					"	Author: " + b.get(i).getAuthor() + 
					"	Year: " + b.get(i).getYear() +
					"	ID: " + b.get(i).getId());
			}
			try{
				System.out.print("\n\t\tEnter choice: ");
				i = sc.nextInt();
				a = b.get(i);
				l.removeBook(a);
				this.borrowedBooks.add(a);
				System.out.println("\n\t\tDone!");
			}catch(Exception e){
				System.out.println("\n\t\tInvalid input.");
			}
		}else{
			System.out.println("\n\t\tBook not available.");
		}
	}



	public void returnBook(Library l){
	/********************************************************************************************
		This method allows the user to return a book to the library.
		It adds the book returned to the library's arraylist of books.
		It removes the book to be returned from the user's arraylist of books.
	********************************************************************************************/
		String bookToReturn;
		int i;
		Iterator bookItr;
		Scanner sc = new Scanner(System.in);
		HashMap<String, ArrayList<Book>> book = l.getBookMap();
		if(borrowedBooks.isEmpty()!=true){
			System.out.println("\n\t\t===Return Books===\n");
			for(i = 0; i < this.borrowedBooks.size(); i++){
				System.out.println("\t\t["+i+"]" +
				" Title: " + borrowedBooks.get(i).getTitle() + 
				"	Author: " + borrowedBooks.get(i).getAuthor() + 
				"	Year: " + borrowedBooks.get(i).getYear() +
				"	ID: " + borrowedBooks.get(i).getId());
			}
			try{
				System.out.print("\n\t\tEnter choice: ");
				i = sc.nextInt();	
				Book a = borrowedBooks.get(i);
				this.borrowedBooks.remove(i);
				l.addBook(a);
				System.out.println("\n\t\tDone!");
			}catch(Exception e){
				System.out.println("\n\t\tInvalid input.");				
			}
		}
		else{
			System.out.println("\n\t\tNo Borrowed Books.");
		}
	}
	public void viewBooksBorrowed(){
	/********************************************************************************************
		This method prints the books borrowed of the user.
	********************************************************************************************/
		int i;
		System.out.println("\n\t\t===Books Borrowed===\n");
		for(i = 0; i < borrowedBooks.size(); i++){
			System.out.println("\t\t["+i+"]" +
			"	Title: " + borrowedBooks.get(i).getTitle() + 
			"	Author: " + borrowedBooks.get(i).getAuthor() + 
			"	Year: " + borrowedBooks.get(i).getYear() +
			"	ID: " + borrowedBooks.get(i).getId());
		}
	}


	public void saveBorrowedBooks(){
	/********************************************************************************************
		The method saves the books borrowed of the user to a csv file.
	********************************************************************************************/
		int i;
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("../bin/borrowedBooks.csv"));
			for(i = 0; i < borrowedBooks.size(); i++){
				pw.write(borrowedBooks.get(i).getTitle() 
						+ "," + borrowedBooks.get(i).getAuthor()
						+ "," + borrowedBooks.get(i).getYear()
						+ "," + borrowedBooks.get(i).getType()
						+ "," + borrowedBooks.get(i).getId());
					pw.write("\n");
			}
			pw.close();
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}


	public void loadBorrowedBooks(){
	/********************************************************************************************
		The method loads the books borrowed of the user from a csv file.
	********************************************************************************************/
		try{
			BufferedReader br = new BufferedReader(new FileReader("../bin/borrowedBooks.csv"));
			String current = null;
			while((current = br.readLine()) != null){
				String[] data = current.split(",");
				Book b = new Book(data[4],data[0],data[1],data[2],data[3]);
				this.borrowedBooks.add(b);
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("\n\t\tFile not found");
		}catch(IOException e){
            System.out.println(e.toString());
        }
	}
}
