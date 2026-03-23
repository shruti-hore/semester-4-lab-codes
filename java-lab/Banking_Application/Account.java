import java.util.*;

public class Account {
    private int accNum;
    private double balance;
    private String accType;
    private List<Transaction> transactions;

    // constructor
    public Account(int accNum, double balance, String accType) {
        this.accNum = accNum;
        this.balance = balance;
        this.accType = accType;
        this.transactions = new ArrayList<>();
    }

    // setter
    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    // getter
    public int getAccNum() {
        return accNum;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }

        balance += amount;

        Transaction t = new Transaction(
            String.valueOf(transactions.size()+1), "Today", amount, "Credit");

        transactions.add(t);

        System.out.println("New balance = " + balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return false;
        }

        balance -= amount;

        Transaction t = new Transaction(
            String.valueOf(transactions.size()+1), "Today", amount, "Debit");

        transactions.add(t);

        System.out.println("New balance = " + balance);
        return true;
    }
}