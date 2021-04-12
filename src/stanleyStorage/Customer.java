package stanleyStorage;

public class Customer implements CustomerInterface {
    private String name;
    private String phone;
    private double balance;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double charge(double amount) {
        this.balance += amount;
        return this.balance;
    }

    public double credit(double amount) {
        this.balance -= amount;
        return this.balance;
    }
}
