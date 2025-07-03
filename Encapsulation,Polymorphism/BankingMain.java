abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String acc, String name, double balance) {
        super(acc, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan applied: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String acc, String name, double balance) {
        super(acc, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan applied: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

public class BankingMain {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SA123", "Alice", 15000);
        BankAccount acc2 = new CurrentAccount("CA456", "Bob", 7000);

        BankAccount[] accounts = { acc1, acc2 };

        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() + ", Holder: " + acc.getHolderName());
            System.out.println("Balance: ₹" + acc.getBalance());
            System.out.println("Interest: ₹" + acc.calculateInterest());
            Loanable loan = (Loanable) acc;
            System.out.println("Loan Eligible: " + loan.calculateLoanEligibility());
            loan.applyForLoan(20000);
            System.out.println();
        }
    }
}
