public class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        balance = initialBalance;
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
            System.out.println("Invalid withdrawal amount!");
        }
    }
    
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0);
        
        account.checkBalance();
        account.deposit(50.0);
        account.withdraw(30.0);
        account.checkBalance();
        account.withdraw(200.0); // Should fail
        account.checkBalance();
    }
}

