import java.util.Scanner;

public class SimpleBankAccount {
    private double balance;
    
    public SimpleBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }
    
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleBankAccount account = new SimpleBankAccount(100.0); // Start with $100
        
        while (true) {
            System.out.println("\n=== Simple Bank Account ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
