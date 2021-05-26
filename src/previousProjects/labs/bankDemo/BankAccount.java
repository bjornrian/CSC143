package previousProjects.labs.bankDemo;

public class BankAccount {
    private int userId;
    private String name;
    private double balance;

    public BankAccount(int userId, String name, double balance) {
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setName(String setName) {
        this.name = setName;
    }

    public void depositMoney(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Error: Negative amount values not accepted.");
        }
        this.balance += amount;
    }

    public void withdrawMoney(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Error: Negative amount values not accepted.");
        }
        this.balance -= amount;
    }
}
