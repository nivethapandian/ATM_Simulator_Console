package atm_simulator;

import java.text.NumberFormat;
import java.util.Scanner;

public class ATMSimulator {
	private static final Scanner sc = new Scanner(System.in);
	private static BankAccount b = new BankAccount(123456, 8910, 2000);

	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println("   Welcome to XYZ Bank");
		System.out.println("======================================");

		System.out.print("Enter Account Number: ");
		long accountNumber = sc.nextLong();
		
		try {
		pinCheck();
		}
		catch(AccountLockedException e) {
			System.out.println("\n  AccountLockedException:");
			System.out.println(e.getMessage());
			System.out.println("  Please contact your bank.\n");
		}
		finally {
			sc.close();
		}
	}

	private static void pinCheck() throws AccountLockedException {
		int count = 3;
		do {
			System.out.print("Enter PIN: ");
			int pin = sc.nextInt();
			if (pin == b.getPin()) {
				System.out.println("\nLogin Successful! Welcome");
				menu();
			}
			count--;
			System.out.println("\nWrong PIN! " + count + " attempts remaining \n");

		} while (count > 0);

		if (count == 0) {
			throw new AccountLockedException("  Your account has been locked after 3 failed attempts");
		}
	}
	
	private static void menu() {
		while(true) {
			System.out.println("\n==============================");
            System.out.println("        ATM Menu");
            System.out.println("==============================");
            System.out.println("  1.  Check balance");
            System.out.println("  2.  Deposit");
            System.out.println("  3.  Withdraw");
            System.out.println("  4.  Transaction history");
            System.out.println("  5.  Logout");
            System.out.println("==============================");
            
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch(choice) {
            case 1:
            	checkBalance();
            	break;
            case 2:
            	deposit();
            	break;
            case 3:
            	withdraw();
            	break;
            case 4:
//            	transactionHistory();
            	break;
            case 5:
            	System.out.println("\n Logged out successfully!");
            	System.out.println(" Thank you for banking with XYZ Bank! \n");
            	System.exit(0);
            default:
            	System.out.println("Invalid choice. Please select 1 - 5");
            }

		}
		}
	
		private static void checkBalance() {
			System.out.println("\n------------------------------");
	        System.out.println("  [ Balance Enquiry ]");
	        System.out.println("------------------------------\n");
	        String balance = NumberFormat.getCurrencyInstance().format(b.getBalance());
	        System.out.println(" Current Balance: "+ balance);
		}
		
		private static void deposit() {
			System.out.println("\n------------------------------");
	        System.out.println("  [ Deposit ]");
	        System.out.println("------------------------------\n");
	        
	        System.out.print("Enter deposit amount: ");
	        
	        
	        try {
	        	sc.nextLine();
	        	double amount = Double.parseDouble(sc.nextLine());
	        	b.getDeposit(amount);
	        	System.out.println("Deposit Successful!\n");
	        	System.out.println("Amount Deposited: " + NumberFormat.getCurrencyInstance().format(amount));
	        	System.out.println("New Balance: " + NumberFormat.getCurrencyInstance().format(b.getBalance()));
	        }
	        catch(NumberFormatException e) {
	        	System.out.println("\n NumberFormatException:");
	        	System.out.println(" Invalid input. Please enter a numeric amount\n");
	        }
	        catch(InvalidAmountException e) {
	        	System.out.println("\n  InvalidAmountException:");
	        	System.out.println(" "+e.getMessage()+"\n");
	        }
		}
		
		private static void withdraw() {
			System.out.println("\n------------------------------");
	        System.out.println("  [ Withdraw ]");
	        System.out.println("------------------------------\n");
	        System.out.println("Enter Withdrawal Amount: ");
	        
	        try {
	        	sc.nextLine();
	        	double amount = Double.parseDouble(sc.nextLine());
	        	b.getWithdraw(amount);
	        	System.out.println("Amount withdrawn: " + NumberFormat.getCurrencyInstance().format(amount));
	        	System.out.println("New Balance     : " + NumberFormat.getCurrencyInstance().format(b.getBalance()));
	        }
	        catch(NumberFormatException e) {
	        	System.out.println("\n  NumberFormatException:");
	        	System.out.println("  Invalid input. Please enter a numeric amount\n");
	        }
	        catch(InvalidAmountException e) {
	        	System.out.println("\n  InvalidAmountException:");
	        	System.out.println(" "+e.getMessage()+"\n");
	        }
	        catch(InsufficientFundsException e) {
	        	System.out.println("\n InsufficientFundsException:");
	            System.out.println(" " + e.getMessage());
	            System.out.println("  Available Balance: " + NumberFormat.getCurrencyInstance().format(b.getBalance()));
	        }
		}

}
