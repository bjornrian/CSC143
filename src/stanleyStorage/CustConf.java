package stanleyStorage;

public class CustConf {

    private String name;
    private String phone;
    private double balance;

    public CustConf(String name, String phone, double balance) {
        this.name = verifyString(name);
        this.phone = verifyPhone(phone);
        this.balance = balance;
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


}
