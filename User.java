

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
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
		System.out.print("What book do you want to borrow? ");
		bookToBorrow = sc.nextLine();
		Iterator bookItr; 
		HashMap<String, ArrayList<Book>> book = l.getBookMap();
		if(book.containsKey(bookToBorrow)){
			System.out.println("Book found!");
			ArrayList<Book> b = book.get(bookToBorrow);
			for(i = 0; i < b.size(); i++){
				System.out.println("[" + i + "]" + 
					" Title: " + b.get(i).getTitle() + 
					" Author: " + b.get(i).getAuthor() + 
					" Year: " + b.get(i).getYear() +
					" ID: " + b.get(i).getId());


				}
			System.out.println("Enter choice: ");
			i = sc.nextInt();
			a = b.get(i);
			l.removeBook(a);
			this.borrowedBooks.add(a);
			}
			else{
				System.out.println("Book not available.");
			}

		

	}



	public void returnBook(Library l){
		String bookToReturn;
		int i;
		Iterator bookItr;
		Scanner sc = new Scanner(System.in);

		HashMap<String, ArrayList<Book>> book = l.getBookMap();
		if(borrowedBooks.isEmpty()!=true){
			for(i = 0; i < this.borrowedBooks.size(); i++){
			System.out.println(i +
			" Title: " + borrowedBooks.get(i).getTitle() + 
			" Author: " + borrowedBooks.get(i).getAuthor() + 
			" Year: " + borrowedBooks.get(i).getYear() +
			" ID: " + borrowedBooks.get(i).getId());
		}
		
		System.out.println("Enter choice: ");
		i = sc.nextInt();	
		Book a = borrowedBooks.get(i);
		this.borrowedBooks.remove(i);
		l.addBook(a);
		}
		else{
			System.out.println("No Borrowed Books");


		}

	}
	public void viewBooksBorrowed(){
		int i;
		for(i = 0; i < borrowedBooks.size(); i++){
			System.out.println(i +
			" Title: " + borrowedBooks.get(i).getTitle() + 
			" Author: " + borrowedBooks.get(i).getAuthor() + 
			" Year: " + borrowedBooks.get(i).getYear() +
			" ID: " + borrowedBooks.get(i).getId());

		}

	}



	public void saveBorrowedBooks(){
		int i;
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("borrowedBooks.csv"));
			for(i = 0; i < borrowedBooks.size(); i++){
				pw.write(borrowedBooks.get(i).getTitle() 
						+ "," + borrowedBooksborrowedBooks.get(current).get(i).getAuthor()
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
			BufferedReader br = new BufferedReader(new FileReader("borrowedBooks.csv"));
			String current = null;
			while(current = br.readLine() != null){
				String[] data = current.split(",");
				Book b = new Book(data[4],data[0],data[1],data[2],data[3]);
				this.borrowedBooks.add(b);
			}
			br.close();




		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}catch(IOException e){
            System.out.println(e.toString());
        }

	}

