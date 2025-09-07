import java.math.BigDecimal;
import java.util.Objects;

public record BankAccount(String accountNumber, String ownerName, BigDecimal balance) {
    
    public BankAccount {
        Objects.requireNonNull(accountNumber, "Account number cannot be null");
        Objects.requireNonNull(ownerName, "Owner name cannot be null");
        Objects.requireNonNull(balance, "Balance cannot be null");
        
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }
    
    public BankAccount deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        return new BankAccount(accountNumber, ownerName, balance.add(amount));
    }
    
    public BankAccount withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        return new BankAccount(accountNumber, ownerName, balance.subtract(amount));
    }
    
    public boolean hasSufficientFunds(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }
    
    @Override
    public String toString() {
        return String.format("Account: %s, Owner: %s, Balance: $%.2f", 
                           accountNumber, ownerName, balance);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Create account with initial balance
        BankAccount account = new BankAccount("123456", "John Doe", new BigDecimal("1000.00"));
        
        // Perform operations (immutable - returns new instances)
        BankAccount afterDeposit = account.deposit(new BigDecimal("500.00"));
        BankAccount afterWithdrawal = afterDeposit.withdraw(new BigDecimal("200.00"));
        
        System.out.println("Original: " + account);
        System.out.println("After deposit: " + afterDeposit);
        System.out.println("After withdrawal: " + afterWithdrawal);
        System.out.println("Can withdraw $300? " + afterWithdrawal.hasSufficientFunds(new BigDecimal("300.00")));
    }
}
