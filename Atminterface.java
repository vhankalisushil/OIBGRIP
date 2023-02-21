/*SUSHILKUMAR K. VHANKALI
  Task:ATM INTERFACE
  Language:JAVA
  OASIS INFOBYTE */


  import java.util.*;
public class AtmInterface
 {
	String username;
	String password;
	String name;
	String accNo;
	float balance=0;
	int noOfTransactions=0;
	String transactionHistory="";
	
	public void createAccount() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your name: ");
		this.name=in.nextLine();
		System.out.println("Enter Account Number: ");
		this.accNo=in.nextLine();
		System.out.println("Enter your username");
		this.username=in.nextLine();
		System.out.println("Enter password");
		this.password=in.nextLine();
		System.out.println();
		System.out.println("Your registration is successfully completed");
	}
	public void login() {
		boolean flag=true;
		Scanner in = new Scanner(System.in);
		while(flag) {
			System.out.println("Enter your username :");
			String Username=in.nextLine();
			if(Username.equals(username)) {
				System.out.println("Enter password");
				String Password=in.nextLine();
				if(Password.equals(password)) {
					System.out.println("Login successful");
					flag=false;
				}
				else
					System.out.println("Password doesn't match, Please try again ");	
			}
			else {
				System.out.println("\n Username Not Found");
			}
		}
	}
	public void deposit() {
		System.out.println("Enter Amount to Deposit:\n(Amount should be greater than zero)");
		Scanner in = new Scanner(System.in);
		float amount=in.nextFloat();
		balance=balance+amount;
		System.out.println("Amount "+amount+" has been Deposited");
		noOfTransactions++;
		String transaction = amount+" has been Credited to your Account\n";
		transactionHistory = transactionHistory.concat(transaction);
		balanceEnquiry();
	}
	public void withdraw() {
		System.out.println("Enter Amount to Withdraw ");
		Scanner in = new Scanner(System.in);
		float amount=in.nextFloat();
		if(balance>=amount) {
			balance =balance-amount;
			System.out.println(amount +" Withdrawal Successful");
			noOfTransactions++;
			String transaction = amount+" has been Successfully Withdrawn\n";
			transactionHistory = transactionHistory.concat(transaction);
			balanceEnquiry();
		}
		else
			System.out.println("Insufficient Balance ");
			balanceEnquiry();
	}
	public void transfer() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter Receiver's Account No. : ");
		int receiver = in.nextInt();
		System.out.println("\nEnter Amount to transfer : ");
		float amount = in.nextFloat();
		if(amount<=balance) {
			balance = balance-amount;
			System.out.println(amount+" Successfully Transferred ");
			noOfTransactions++;
			String transaction = amount+" Transferred to "+receiver+"\n";
			transactionHistory = transactionHistory.concat(transaction);
			balanceEnquiry();
		}
	}
	public void balanceEnquiry() {
		System.out.println("Your Account Balance is "+balance);
	}	
	public void transactionHistory() {
		System.out.println("\n"+transactionHistory);
	}
	public static void main(String[] args)
	 {
		Scanner in = new Scanner(System.in);
		System.out.println(" **WELCOME TO ATM INTERFACE***\n\n");
		System.out.println(" Enter 1 to Create Account\n 0 to exit\n");
		System.out.println("Enter your Preference");
		int input=in.nextInt();
		if(input==1) {
			AtmInterface user = new AtmInterface();
			user.createAccount();
			System.out.println("\nPlease Enter ATM Details to Login\n");
			user.login();
			boolean exit=false;
			while(!exit) {
				System.out.println("\n1.Deposit \n2.Withdraw \n3.Transfer \n4.Check Balance \n5.Check Transactions \n6.Exit\n");
				System.out.println("Enter your choice");
				int choice = in.nextInt();
				if(choice<7 && choice>0) {
					switch(choice) {
					case 1:user.deposit();
							break;
					case 2:user.withdraw();
							break;
					case 3:user.transfer();
							break;
					case 4:user.balanceEnquiry();
							break;
					case 5:user.transactionHistory();
							break;
					case 6:exit=true;
							break;
					
					}
				}
			}
		}
	}
	}
