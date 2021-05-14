package previousProjects.stanleyStorage;

/**
 * Represents a customer that rents a storage unit.
 * Contains personal data such as name and phone number.
 * This class keeps track of the balance that the customer owes.
 */
public class Customer {
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

    /**
     * Charge the customer and update the balance
     *
     * @param amount
     * @return
     */
    public double charge(double amount) {
        verifyAmount(amount);
        this.balance += amount;
        return this.balance;
    }

    /**
     * Credit the customer and update the balance
     *
     * @param amount
     * @return
     */
    public double credit(double amount) {
        verifyAmount(amount);
        this.balance -= amount;
        return this.balance;
    }

    @Override
    public String toString() {
        return  "Customer: " +
                "Name = " + name +
                ", Phone = " + phone +
                ", Balance = $" + balance;
    }

    /**
     * Verifies that a double amount of money is not a negative value.
     *
     * @param amount money value
     */
    private void verifyAmount(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Error: Amount cannot be less than zero.");
        }
    }

    /**
     * Verifies that the string parameter is not empty or equal to null.
     *
     * @param str
     */
    private void verifyString(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Error: String cannot be empty or equal to null.");
        }
    }
}
