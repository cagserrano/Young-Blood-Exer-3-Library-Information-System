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
	

	public void borrowBook(Library l){
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
