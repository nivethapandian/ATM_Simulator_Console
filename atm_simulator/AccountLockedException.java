package atm_simulator;

class AccountLockedException extends Exception {
	public AccountLockedException(String message) {
		super(message);
	}
}

class InvalidAmountException extends Exception {
	 public InvalidAmountException(String message) {
		super(message);
	}
}

class InsufficientFundsException extends Exception {
	 public InsufficientFundsException(String message) {
		super(message);
	}
}