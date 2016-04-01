import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{
	public static void main(String[] args){
		int choice;
		String name, username, password;
		name=name();
		username=username();
		password=password();
		User user=new User(name, username, password);
		Library l = new Library();
		
		do{
			choice = printMenu();
			switch(choice){
				case 1:
					user.borrowBook(l);
					break;
				case 2:
					user.returnBook(l);
					break;
				case 3:
					l.viewLibraryBooks();
					break;
				case 4:
					user.viewBooksBorrowed();
					break;
				case 5:
					System.out.println("Thank you!");
					break;
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
	
	public static String name(){
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name: ");
		name=sc.nextLine();
		return name;
	} 
	
	public static String username(){
		String username;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Username: ");
		username=sc.nextLine();
		return username;
	
	}
	public static String password(){
		String password;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Password: ");
		password=sc.nextLine();
		return password;
	}
	
	
	
	/*public static void register(){
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
			writer.writeline(username + "," + password);
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
	}*/
}

