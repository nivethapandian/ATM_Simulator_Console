package atm_simulator;

import java.text.NumberFormat;
import java.util.ArrayList;

public class BankAccount {
	private long accountNumber;
	private int pin;
	private double balance;
	private ArrayList<String> transactions;
	
	
	BankAccount(long accountNumber, int pin, double balance){
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
		this.transactions = new ArrayList<>();
		this.transactions.add("Opening Balance    : " + NumberFormat.getCurrencyInstance().format(balance));
	}
	
	public void getDeposit(double amount) throws InvalidAmountException {
		if(amount < 100) {
			throw new InvalidAmountException(" Maximum deposit amount is Rs. 100");
		}
		balance += amount;
		this.transactions.add("Deposited          : " + NumberFormat.getCurrencyInstance().format(amount));
	}
	
	public void getWithdraw(double amount) throws InsufficientFundsException, InvalidAmountException{
		if(amount > balance) {
			throw new InsufficientFundsException(" Insufficient Balance!");
		}
		if(amount < 100) {
			throw new InvalidAmountException(" Maximum withdrawal amount is Rs. 100");
		}
		balance -= amount;
		this.transactions.add("Withdrawn          : " + NumberFormat.getCurrencyInstance().format(amount));
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getPin() {
		return pin;
	}
	
	public ArrayList<String> getHistory() {
		return transactions;
	}
	
	

	
}
