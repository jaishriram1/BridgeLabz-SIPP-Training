class Customer {
    String name;
    double balance;
    
    Customer(String name) {
        this.name = name;
        this.balance = 0;
    }

    void viewBalance() {
        System.out.println(name + "'s balance: $" + balance);
    }

    void deposit(double amount) {
        balance += amount;
    }
}

class Bank {
    String name;
    Bank(String name) {
        this.name = name;
    }

    void openAccount(Customer customer, double initialDeposit) {
        customer.deposit(initialDeposit);
        System.out.println("Account opened for " + customer.name + " at " + name);
    }
}

public class BankCustomerAssociation {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");
        Customer customer = new Customer("Alice");

        bank.openAccount(customer, 500);
        customer.viewBalance();
    }
}
