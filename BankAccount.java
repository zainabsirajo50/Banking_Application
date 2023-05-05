import java.util.*;
public class BankAccount {
	int balance;
	int previousTransactions;
	String customerName;
	String customerId;
	
	
	BankAccount(String name, String id) {
		 customerName = name;
		 customerId = id;
	}
	
	
	 void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransactions = amount;
		}
		
	}
	
	public void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransactions = -amount;
		}
	}
	
	public void previousTransactions() {
		if(previousTransactions > 0) {
			System.out.println("Deposit: " + previousTransactions);
		}
		else if(previousTransactions < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransactions));
		} else {
			System.out.println("No transactions occured");
		}
	}
	
	public void showMenu() {
		char option = '/';
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your id is " + customerId);
		
		System.out.println();
		
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transactions");
		System.out.println("E. Exit");
		
		do {
			
			System.out.println("*************************");
			System.out.println("     Enter an Option     ");
			System.out.println("*************************");
			
			option = input.next().charAt(0);
			System.out.println();
			
			
			switch(option) {
			case 'A':
				System.out.println("Balance = " + balance);
				break;
			case 'B':
				System.out.print("Enter amount you wish to deposit >> ");
				int depAmount = input.nextInt();
				deposit(depAmount);
				System.out.println();
				break;
			case 'C':
				System.out.print("Enter amount you wish to withdraw >> ");
				int withAmount = input.nextInt();
				withdraw(withAmount);
				System.out.println();
				break;
			case 'D':
				previousTransactions();
				System.out.println();
				break;
			case 'E':
				System.out.print("");
				break;
			default:
				System.out.println("Invalid Entry. Please Try Again.");
				break;
			}
			
		} while(option != 'E');
		
		System.out.println("Thank you for using our services. Please Come Again");
	}
	
	
}
