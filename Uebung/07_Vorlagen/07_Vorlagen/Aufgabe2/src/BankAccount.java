public class BankAccount {
	private int balance;
	private final int lowerLimit;
	private final int upperLimit;
	
	public BankAccount(int balance, int lowerLimit, int upperLimit) {
		this.balance = balance; 
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
	public void deposit(int amount) throws LimitExceededException {
		if (amount < 0) {
			throw new IllegalArgumentException("Invalid negative amount");
		}
		if (balance + amount > upperLimit) {
			throw new LimitExceededException("Upper limit exceeded");
		}
		balance += amount;
	}
	
	public void withdraw(int amount) throws LimitExceededException {
		if (amount < 0) {
			throw new IllegalArgumentException("Invalid negative amount");
		}
		if (balance - amount < lowerLimit) {
			throw new LimitExceededException("Lower limit exceeded");
		}
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
}
