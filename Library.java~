import java.util.HashMap;
import java.util.ArrayList;
public class Library{
	private HashMap<String, ArrayList<Book>> bookMap;

	public Library(){
		bookMap = new HashMap<String, ArrayList<Book>>();
	}		
	

	public void loadBooks(){
		System.out.println("Loading books from CSV file");
		
		try{
			int ID=0;
			String current = null;
			BufferedReader br = new BufferedReader(new FileReader("books.csv"));
			while((current = br.readLine()) != null){
				String[] data = current.split(",");
				Book b= new Book(ID, data[0], data[1], data[2], data[4]);
				if(bookMap.containsKey(data[0]) != true){
					bookMap.put(data[0], new ArrayList<Book>());
				}	
				bookMap.get(data[0]).add(b);
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


	}
}
