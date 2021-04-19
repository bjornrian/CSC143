package stanleyStoragePartTwo;

/**
 * Represents a customer that rents a storage unit.
 * Contains personal data such as name and phone number.
 * This class keeps track of the balance that the customer owes.
 */
public class Customer implements CustomerInterface {
    private String name;
    private String phone;
    private double balance;

    /**
     * Constructor
     *
     * @param name the customer's name
     * @param phone the customer's phone number
     */
    public Customer(String name, String phone) {
        verifyString(name);
        verifyString(phone);
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
        verifyString(name);
        this.name = name;
    }

    public void setPhone(String phone) {
        verifyString(phone);
        this.phone = phone;
    }

    public double charge(double amount) {
        verifyAmount(amount);
        this.balance += amount;
        return this.balance;
    }

    public double credit(double amount) {
        verifyAmount(amount);
        this.balance -= amount;
        return this.balance;
    }

    @Override
    public String toString() {
        return  "Customer:\n" +
                "---------\n" +
                "Name = " + name + '\n' +
                "Phone = " + phone + '\n' +
                "Balance = $" + balance + '\n';
    }

    private void verifyAmount(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Error: Amount cannot be less than zero.");
        }
    }

    private void verifyString(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Error: String cannot be empty or equal to null.");
        }
    }
}
