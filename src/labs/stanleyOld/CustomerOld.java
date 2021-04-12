package labs.stanleyOld;

public class CustomerOld {

    private String name;
    private String phone;
    private double balance;

    public CustomerOld(String name, String phone, double balance) {
        this.name = verifyString(name);
        this.phone = verifyPhone(phone);
        this.balance = verifyBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void chargeCust(double amount) {
        this.balance += amount;
    }

    public void creditCust(double amount) {
        this.balance -= amount;
    }

    private String verifyString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Error: String cannot be equal to null or empty.");
        }
        return str;
    }

    private String verifyPhone(String phone) {
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Error: Phone number is not of valid length.");
        }
        return phone;
    }

    private double verifyBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Error: Balance can't have a negative value.");
        }
        return balance;
    }
}
