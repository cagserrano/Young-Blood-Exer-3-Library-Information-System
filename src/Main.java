import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**********************************************************************************************************
	The program Library Information System simulates the borrowing of a book, returning of a book, view the
books inside the library, and viewing the books the user has borrowed.
***********************************************************************************************************/
public class Main{
	public static void main(String[] args){
		int choice;
		do{
			choice = mainMenu();
			switch(choice){
				case 1:
					register();
					break;
				case 2:
					login();
					break;
				case 3:
					System.out.println("\n\tThank you!");
					break;
				default:
					System.out.println("\n\tInvalid choice.");
			}
		}while(choice != 3);
	}
	public static int mainMenu(){
	/********************************************************************************************
		This method prints the main menu and return user's choice.
	********************************************************************************************/
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n===Library Information System===");
		System.out.println("\t[1] Register");
		System.out.println("\t[2] Login");
		System.out.println("\t[3] Exit");
		System.out.print("\tChoice: ");
		choice = sc.nextInt();
		return choice;	
	}
	public static int printMenu(){
	/********************************************************************************************
		This method prints the menu and return user's choice.
	********************************************************************************************/
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t=====MENU=====");
		System.out.println("\t\t\t[1] Borrow a Book");
		System.out.println("\t\t\t[2] Return a Book");
		System.out.println("\t\t\t[3] View books in the library");
		System.out.println("\t\t\t[4] View borrowed books");
		System.out.println("\t\t\t[5] Logout");
		System.out.print("\t\t\tChoice: ");
		choice = sc.nextInt();
		return choice;
	}

	public static void register(){
	/*********************************************************************************
	Register: User can sign up to the library information system.
		This method saves the user's name, username and password to accounts.csv file.
	**********************************************************************************/
		String name,username, password;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t===Register===");
		System.out.print("\tName: ");
		name = sc.nextLine();
		System.out.print("\tUsername: ");
		username = sc.nextLine();
		System.out.print("\tPassword: ");
		password = sc.nextLine();
		try{
			File file = new File("../bin/accounts.csv");
			PrintWriter writer = new PrintWriter(new FileWriter(file, true));
			writer.println(name + "," + username + "," + password);
			writer.close();
			System.out.println("\n\tSuccessful!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n\tCannot write to \"accounts.csv\".");
		}
	}
	
	public static void login(){
	/*****************************************************************************************************
	Login: User can login to the library information system and access the borrowing, returning of a book.
		This method will check the authentication of user's inputs of his/her username and password from 
	the accounts.csv file. If authenticated then the user can now borrow or return a book, else the user
	can not access these methods.
	******************************************************************************************************/
		int choice1;
		Library l = new Library();
		l.loadBooks();
		String username, password;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t===Login===");
		System.out.print("\tUsername: ");
		username = sc.nextLine();
		System.out.print("\tPassword: ");
		password = sc.nextLine();
		try{
			String current = null;
			BufferedReader br = new BufferedReader(new FileReader("../bin/accounts.csv"));
			while((current = br.readLine()) != null){
				String[] data = current.split(",");
				if(username.equals(data[1]) && password.equals(data[2])){
					User user = new User(data[0],data[1],data[2]);
					System.out.println("\n\tHello! "+data[0]+".");
					do{
						choice1 = printMenu();
						switch(choice1){
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
								System.out.println("\n\tThank you!");
								break;
							default:
								System.out.println("\n\tInvalid choice.");
						}
					}while(choice1 != 5);
				}
			}		
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("\tFile not found");
		}catch(IOException e){
            System.out.println(e.toString());
        }
	}
}

