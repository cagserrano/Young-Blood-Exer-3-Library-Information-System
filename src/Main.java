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
		System.out.println("\n===Library Information System===");
		name=name();
		username=username();
		password=password();
		User user=new User(name, username, password);
		Library l = new Library();
		l.loadBooks();
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
					l.saveBooks();
					System.out.println("Thank you!");
					break;
				default:
					System.out.println("Invalid choice.");
			}
		}while(choice != 5);
	}
	public static int printMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t=====MENU=====");
		System.out.println("\t\t\t[1] Borrow a Book");
		System.out.println("\t\t\t[2] Return a Book");
		System.out.println("\t\t\t[3] View books in the library");
		System.out.println("\t\t\t[4] View borrowed books");
		System.out.println("\t\t\t[5] Exit");
		System.out.print("\t\t\tChoice: ");
		choice = sc.nextInt();
		return choice;
	}
	
	public static String name(){
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\tEnter Name: ");
		name=sc.nextLine();
		return name;
	} 
	
	public static String username(){
		String username;
		Scanner sc = new Scanner(System.in);
		System.out.print("\tEnter Username: ");
		username=sc.nextLine();
		return username;
	
	}
	public static String password(){
		String password;
		Scanner sc = new Scanner(System.in);
		System.out.print("\tEnter Password: ");
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
<<<<<<< HEAD
			//writer.writeline(username+","+password);
=======
			writer.writeline(username + "," + password);
>>>>>>> c4ee57904956e7bbc11d494630be686a35d0a920
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

