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

public class Library{
	private HashMap<String, ArrayList<Book>> bookMap;

	public Library(){
		bookMap = new HashMap<String, ArrayList<Book>>();
	}		
	

	public void loadBooks(){
		System.out.println("\n\tLoading books from CSV file");
		try{
			int iD=0, x;
			String current = null;
			Random r = new Random();
			BufferedReader br = new BufferedReader(new FileReader("../bin/books.csv"));
			while((current = br.readLine()) != null){
				String[] data = current.split(",");
				x = r.nextInt(6) + 15;
				for(int i =0;i<x;i++){
					Book b= new Book(Integer.toHexString(iD), data[0], data[1], data[2], data[3]);
					if(bookMap.containsKey(data[0]) != true){
						bookMap.put(data[0], new ArrayList<Book>());
					}	
						
					bookMap.get(data[0]).add(b);
					iD += 1;
				}	
			}			
			br.close();
			System.out.println("\tBooks Added!");
		}catch(FileNotFoundException e){
			System.out.println("\tFile not found");
		}catch(IOException e){
            System.out.println(e.toString());
        }
	}

	public void saveBooks(){
		try{	
			PrintWriter pw = new PrintWriter(new FileWriter("../bin/books.csv"));	
			Iterator bookIterator = bookMap.keySet().iterator();
			while(bookIterator.hasNext() != false){
				String current = bookIterator.next().toString();
				for(int i=0;i<bookMap.get(current).size();i++){	
					pw.write(bookMap.get(current).get(i).getTitle() 
						+ "," + bookMap.get(current).get(i).getAuthor()
						+ "," + bookMap.get(current).get(i).getYear()
						+ "," + bookMap.get(current).get(i).getType()
						+ "," + bookMap.get(current).get(i).getId());
					pw.write("\n");
				}
			}	
			pw.close();
			System.out.println("\tDone!");
		}catch(IOException e){
			System.out.println(e.toString());
		}

	}

	public void viewLibraryBooks(){
		Iterator booksIterator = bookMap.keySet().iterator();
		int number, i=1;
		System.out.println("\n\t\t===Books in the Library===\n");
		while(booksIterator.hasNext()){	
			String current = booksIterator.next().toString();
			number = bookMap.get(current).size();
			System.out.println("\t\t[" + i + "] " + "Title: " + current);
			System.out.println("\t\t    Quantity: " + number + "\n");			
			i += 1; 
		}
	}

	public HashMap getBookMap(){
		return bookMap;
	}
	
	public void removeBook(Book b){
		bookMap.get(b.getTitle()).remove(b);
	}

	public void addBook(Book b){
		bookMap.get(b.getTitle()).add(b);
	} 
}
