import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Library{
	private HashMap<String, ArrayList<Book>> bookMap;

	public Library(){
		bookMap = new HashMap<String, ArrayList<Book>>();
	}		
	

	public void loadBooks(){
		System.out.println("Loading books from CSV file");
		try{
			int iD=0;
			String current = null;
			BufferedReader br = new BufferedReader(new FileReader("books.csv"));
			while((current = br.readLine()) != null){
				String[] data = current.split(",");
				Book b= new Book(Integer.toHexString(iD), data[0], data[1], data[2], data[3]);
				if(data[4] != null){
					b.setId(data[4]);
				}
				if(bookMap.containsKey(data[0]) != true){
					bookMap.put(data[0], new ArrayList<Book>());
				}	
				bookMap.get(data[0]).add(b);
				iD += 1;
			}			
			br.close();
			System.out.println("Books Added!");
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}catch(IOException e){
            System.out.println(e.toString());
        }
	}

	public void saveBooks(){
		try{	
			PrintWriter pw = new PrintWriter(new FileWriter("books.csv"));	
			Iterator bookIterator = bookMap.keySet().iterator();
			while(bookIterator.hasNext() != false){
				String current = bookIterator.next().getTitle();
				pw.write(bookMap.get(current).getTitle() 
					+ "," + bookMap.get(current).getAuthor()
					+ "," + bookMap.get(current).getYear()
					+ "," + bookMap.get(current).getType()
					+ "," + bookMap.get(current).getId());
				pw.write("\n");
			}	
			pw.close();
			System.out.println("Done!");
		}catch(IOException e){
			System.out.println(e.toString());
		}

	}

	public void viewLibraryBooks(){
		Iterator booksIterator = bookMap.keySet().iterator();
		while(booksIterator.hasNext() != false){	
			for(int i=0;i<bookMap.get(booksIterator.next().toString()).size();i++){		
				System.out.println(bookMap.get(booksIterator.next().toString()).get(i).getTitle());	
			}
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
