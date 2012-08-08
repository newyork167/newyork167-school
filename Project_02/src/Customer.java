
public class Customer {
	String name, accountNumber, pin;
	Account[] accounts = new Account[3];
	
	public Customer(String name, Account checkings, Account savings, Account moneyMarket){
		this.name = name;
		accounts[0] = checkings;
		accounts[1] = savings;
		accounts[2] = moneyMarket;
	}
	
	public void changePin(String pin){
		this.pin = pin;
	}
	
	public void changeAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public String toString(){
		return "Name: " + name + "\nChecking Balance: " + accounts[0].balance + "\nSavings Balance: " + accounts[1].balance + "\nMoney Market Balance: " + accounts[2].balance + "\nAccount Number: " + accountNumber + "\nPIN: " + pin;
	}
}
