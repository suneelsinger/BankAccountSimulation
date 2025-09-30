import java.util.ArrayList;
import java.util.*;
class Account
{
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;
    public Account(String accountHolder,double initialBalance)
    {
        this.accountHolder=accountHolder;
        this.balance=initialBalance;
        this.transactions=new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }
    // Deposit method
    public void deposit(double amount)
    {
        if(amount>0)
        {
            balance+=amount;
            transactions.add("Deposited: "+amount+" | New Balance: "+balance);
            System.out.println("Successfully deposited: "+amount);
        }
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    // Withdraw method
    public void withdraw(double amount)
    {
        if(amount>0 && amount<=balance)
        {
            balance-=amount;
            transactions.add("Withdrawn: " + amount + " | New Balance: " + balance);
            System.out.println("Successfully withdrawn: " + amount);
        }
        else
        {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    // Check balance
    public double getBalance()
    {
        return balance;
    }
    // Print transaction history
    public void printTransactions()
    {
        System.out.println("\nTransaction History:");
        for(String t:transactions)
        {
            System.out.println(t);
        }
    }
}
// Main Class
public class BankAccountSimulation
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name=sc.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance=sc.nextDouble();
        Account account=new Account(name,initialBalance);
        // Menu
        int choice;
        do
        {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount=sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount=sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 4:
                    account.printTransactions();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        while(choice!=5);
        sc.close();
    }
}
