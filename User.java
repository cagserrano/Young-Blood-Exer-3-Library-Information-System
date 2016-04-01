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
		ListIterator bookItr = books.iterator();
		while(bookItr.hasNext()){
			Book a = bookItr.next();
			if(bookToBorrow.compareToIgnoreCase(a.getTitle())==0){
				System.out.println("Book found!");
				this.borrowedBooks.add(a);
				books.remove(a);
				break;
			}
			else{
				System.out.println("Book not available.");
			}

		}

	}


	public void returnBook(ArrayList<Book> books, Book book){
		String bookToReturn;
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title of book to return: ");
		bookTorReturn = sc.nextLine();
		ListIterator bookItr = this.borrowedBooks.iterator();
		while(bookItr.hasNext()){
			Book a = bookItr.next();
			System.out.println("Title: " + a.getTitle());
			if(bookToReturn.compareToIgnoreCase(a.getTitle())==0){
				System.out.println("Book found!");
				for(i = 0; i < borrowedBooks.size(); i++){
					if(a.getName().compareToIgnoreCase(borrowedBooks.get(i).getTitle()) == 0){
						books.add(a);
						borrowedBooks.remove(i);
						break;
					}

				}

				break;

			}



		}


	}

}
