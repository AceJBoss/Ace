import java.util.Scanner;

public class Bank
{

	//application for withdrawing and depositing money to our account;
	//methods() withdraw, deposit, getbalance, setbalance,setAccountNumber, setAccountName, getAccountNumber, getAccountName;
	// variable accouunt_balance, account_number;
	
	// varibles declaration
	private double account_balance;
	private long account_number;
	private String account_name;
	
	//methods declaration
	
	public void setAccountNumber(long account)
	{
		account_number = account;
	}
	public long getAccountNumber()
	{
		return account_number;
	}
	public void setAccountName(String account)
	{
		account_name = account;
	}
	public String getAccountName()
	{
		return account_name;
	}
	public void setBalance(double amount)
	{
		account_balance += amount;
	}
	public double getBalance()
	{
		return account_balance;
	}
	public void deposit(double amount)
	{
		setBalance(amount); 
	}
	public void withdraw(double amount)
	{
		if(getBalance() >= amount)
		{
			setBalance(-amount);
		}else
		{
			System.out.println("You cannt withdraw");
		}
	}
	public static void main(String [] args)
	{
		System.out.println("Welcome To Java Banking System");
		Scanner x = new Scanner(System.in);
		Bank bank = new Bank();
		
		System.out.println("Supply your account name");
		String name = x.nextLine();
		bank.setAccountName(name);
		//bank.setAccountName(x.nextLine());
		
		System.out.println("Supply your account number");
		long account_number = x.nextLong();
		bank.setAccountNumber(account_number);
		
		int option;
		while(true)
		{
			System.out.println("Press 1 to check your Balance\nPress 2 to withdraw\nPress 3 to Deposit");
			option = x.nextInt();
			if(option == 1)
			{
				System.out.printf("Dear %s with account number %d your account balance is %.2f\n", bank.getAccountName(),bank.getAccountNumber(),bank.getBalance());
			}else if(option == 2)
			{
				System.out.printf("%s, enter the amount to withdraw", bank.getAccountName());
				double amount = x.nextDouble();
				bank.withdraw(amount);
				System.out.println("Transaction successfull");
				System.out.printf("Dear %s with account number %d your new balance is %.2f\n", bank.getAccountName(), bank.getAccountNumber(), bank.getBalance());
			}else if(option == 3)
			{
				System.out.printf("%s, enter the amount to deposit", bank.getAccountName());
				double amount = x.nextDouble();
				bank.deposit(amount);
				System.out.println("Transaction succesfull");
				System.out.printf("Dear %s with account number %d your new balance is %.2f\n", bank.getAccountName(), bank.getAccountNumber(), bank.getBalance());
			}else
			{
				System.out.println("Invalid Transaction");
				
			}
		}
		
	}
}