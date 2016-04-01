import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int choice;
		do{
			choice = printMenu();
			switch(choice){
				case 1:
				case 2:
				case 3:
				case 4:
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
	
}