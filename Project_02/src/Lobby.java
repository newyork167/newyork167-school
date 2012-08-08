import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Lobby {
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<String[]> transactions = new ArrayList<String[]>();
	Customer current;
	double dailyTotal = 0;
	File customerData;
	FileWriter transactionData;
	OptionsGUI options;
	Transaction transaction;
	CloseAccount close;
	
	// Constructor
	public Lobby() throws IOException{
		OpenAccountGUI test1 = new OpenAccountGUI(this);
		options = new OptionsGUI(this, test1);
		transaction = new Transaction(this);
		close = new CloseAccount(this);
		readCustomerFile();
	}
	
	// Method for initially attempting to read customer data file
	public void readCustomerFile() {
		try{
			customerData = new File(JOptionPane.showInputDialog(null, "Please input customer data file path"));
			if(!customerData.exists()){
				throw new FileNotFoundException();
			}
			else{
				int customerCount  = 0;
				Scanner fileInput = new Scanner(customerData);
				while(fileInput.hasNext()){
					customers.add(new Customer(fileInput.next(), new Account(fileInput.nextDouble()), new Account(fileInput.nextDouble()), new Account(fileInput.nextDouble())));
					customers.get(customerCount).pin = fileInput.next();
					customers.get(customerCount).accountNumber = fileInput.next();
					customerCount++;
				}
				nextCustomer();
			}
		} catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Customer File cannot be accessed.\nReading failed\nLobby operations continue.");
			nextCustomer();
		}
	}
	
	// Method for calling next customer
	public void nextCustomer(){
		String[] choices = {"Yes", "No"};
		
		int nextCustomer = JOptionPane.showOptionDialog(null, "Ready for the next customer?", "Programmer's Bank", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "No");
		switch(nextCustomer){
		case 0:
			options.frame.setVisible(true);
			break;
		case -1:
		default:
			closeTheLobby();
		}
	}
	
	// Opens account and calls informationGUI JFrame
	public void openAccount(String name, double checkings, double savings, double moneyMarket){
		Customer customer = new Customer(name, new Account(checkings), new Account(savings), new Account(moneyMarket));
		customer.pin = generatePin();
		customer.accountNumber = generateAccountNumber();
		customers.add(customer);
		String[] temp = new String[2];
		double amount = checkings + savings + moneyMarket;
		temp[0] = customer.accountNumber;
		temp[1] = Double.toString(amount);
		transactions.add(temp);
		InformationGuiOpenAccount test = new InformationGuiOpenAccount(this, name, checkings, savings, moneyMarket, customer.accountNumber, customer.pin);
	}
	
	// Method for finding a specific customer based on name/pin combo
	public Customer identifier(String name, String pin){
		for(int i=0;i<customers.size();i++){
			if(customers.get(i).name.equals(name)){
				if(customers.get(i).pin.equals(pin)){
					return customers.get(i);
				}
			}
		}
		return null;
	}
	
	// Closes the lobby and writes data to file
	public void closeTheLobby(){
		JOptionPane.showMessageDialog(null, "The lobby is closed\nWriting data to file");
		
		// Sorry for the mess, I got bored and decided to play around with the code
		try{
			FileWriter output = new FileWriter(customerData);
			BufferedWriter out = new BufferedWriter(output);
			for(int i=0;i<customers.size();i++){
				out.write(customers.get(i).name);
				out.write(" ");
				out.write(Double.toString(customers.get(i).accounts[0].balance));
				out.write(" ");
				out.write(Double.toString(customers.get(i).accounts[1].balance));
				out.write(" ");
				out.write(Double.toString(customers.get(i).accounts[2].balance));
				out.write(" ");
				out.write(customers.get(i).pin);
				out.write(" ");
				out.write(customers.get(i).accountNumber);
				out.newLine();
			}
			out.close();
		} catch(IOException e){
			JOptionPane.showMessageDialog(null, "File writing failed.\nCheck the path and the drive.\nTry again.");
			customerData = new File(JOptionPane.showInputDialog(null, "Please enter filepath"));
			closeTheLobby();
		}
		
		try{
			transactionData = new FileWriter(new File(JOptionPane.showInputDialog(null, "Enter path for transaction data")), true);
			BufferedWriter out = new BufferedWriter(transactionData);
			Date date = new Date();
			out.append("\r\n");
			out.append(date.toString());
			out.append("\r\n");
			for(int i=0;i<transactions.size();i++){
				out.append("Account: " + transactions.get(i)[0] + " - Transaction amount: " + transactions.get(i)[1]);
				out.append("\r\n");
			}
			out.append("\r\n");
			out.close();
			System.exit(0);
		} catch(IOException e){
			JOptionPane.showMessageDialog(null, "File writing failed.\nCheck the path and the drive.\nTry again.");
			try {
				transactionData = new FileWriter(new File(JOptionPane.showInputDialog(null, "Enter path for transaction data")), true);
				BufferedWriter out = new BufferedWriter(transactionData);
				Date date = new Date();
				out.append("\r\n");
				out.append(date.toString());
				out.append("\r\n");
				for(int i=0;i<transactions.size();i++){
					out.append("Account: " + transactions.get(i)[0] + " - Transaction amount: " + transactions.get(i)[1]);
					out.append("\r\n");
				}
				out.append("\r\n");
				out.close();
				System.exit(0);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Writing to default path - " + System.getProperty("user.home") +"\\TransactionData.txt");
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\TransactionData.txt"));
					Date date = new Date();
					out.append("\r\n");
					out.append(date.toString());
					out.append("\r\n");
					for(int i=0;i<transactions.size();i++){
						out.append("Account: " + transactions.get(i)[0] + " - Transaction amount: " + transactions.get(i)[1]);
						out.append("\r\n");
					}
					out.append("\r\n");
					out.close();
					System.exit(0);
				} catch (IOException e2) {
					System.out.println("Fatal error encountered.");
					System.exit(0);
				}
			}
		}
		System.exit(0);
	}
	
	// Method for generating a new account number
	public String generateAccountNumber(){
		Random random = new Random();
		int accountNumber = random.nextInt(1000000000) + 100000000;
		for(int i=0;i<customers.size();i++){
			if(customers.get(i).accountNumber.equals(Integer.toString(accountNumber))){
				accountNumber = random.nextInt(1000000000) + 100000000;
				i = -1;
			}
		}
		return Integer.toString(accountNumber);
	}
	
	// Method for generate a new pin number
	public String generatePin(){
		Random random = new Random();
		int pin = random.nextInt(9999);
		for(int i=0; i<customers.size();i++){
			if(Integer.toString(pin) == customers.get(i).pin){
				pin = random.nextInt(9999);
				i = -1;
			}
		}
		return Integer.toString(pin);
	}
}
