import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class Main{
	public static void main(String[] args){
		int choice;
		Library l = new Libary();
		user();
		do{
			choice = printMenu();
			switch(choice){
				case 1:
					user.borrowBook(l.getBookMap());
				case 2:
					user.returnBook(l.getBookMap());
				case 3:
					l.viewLibraryBooks();
				case 4:
					user.viewBooksBorrowed();
				case 5:
				default:
			}
		}while(choice != 5);
	}
	public static int printMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] Borrow a Book");
		System.out.println("[2] Return a Book");
		System.out.println("[3] View books in the library");
		System.out.println("[4] View borrowed books");
		System.out.println("[5] Exit");
		choice = sc.nextInt();
		return choice;
	}
	public static void user(){
		String name;
		String username;
		String password;
		Scanner sc = new Scanner(System.in);
		Sytem.out.print("Enter Name: ");
		name=sc.nextLine();
		Sytem.out.print("Enter Username: ");
		username=sc.nextLine();
		Sytem.out.print("Enter Password: ");
		password=sc.nextLine();
		User user=new User(name, username, password);
	
	}
	
	
	public static void register(){
		String username, password;
		Scanner sc = new Scanner(System.in);
		System.out.println("===Register===");
		System.out.print("Username: ");
		username = sc.nextLine();
		System.out.print("Password: ");
		password = sc.nextLine();
		try{
			File file = new File("accounts.csv");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.writeline(username+","+password);
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Cannot write to \"accounts.csv\".");
		}
	}
	public static void login(){
		String username, password;
		Scanner sc = new Scanner(System.in);
		System.out.println("===Login===");
		System.out.println("Username: ");
		username = sc.nextLine();
		System.out.print("Password: ");
		password = sc.nextLine();
		
		try{
			String current = null;
			BufferedReader br = new BufferedReader(new FileReader("accounts.csv"));
			while((current = br.readLine()) != null){
				String[] data = current.split(",");
				if((data[0] == username) && (data[1] == password)){
					//bookMap.put(data[0], new ArrayList<Book>());

				}	
				//bookMap.get(data[0]).add(b);
			}			
			br.close();
			System.out.println("Successful Added!");
		}catch(FileNotFoundException e){
			System.out.println("File \"accounts.csv\" not found.");
		}catch(IOException e){
            System.out.println(e.toString());
        }
	}
}

