package previousProjects.stanleyStorage.labs.midtermOne;

/**
 * An item object represents a basic item that contains important information like
 * the category type, name, price, and quantity of the item.
 */
public class Item {

    private String category;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructor
     *
     * @param category label the item from its general characteristics
     * @param name specific item type
     * @param price double that represents the price of said item
     * @param quantity amount of items, if quantity is 0 then input is 0
     */
    public Item(String category, String name, double price, int quantity) {
        verifyString(category);
        verifyString(name);
        verifyDouble(price);
        verifyInt(quantity);
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        verifyString(name);
        this.name = name;
    }

    public void setPrice(double price) {
        verifyDouble(price);
        this.price = price;
    }

    public void setQuantity (int quantity) {
        verifyInt(quantity);
        this.quantity = quantity;
    }

    public String toString() {
        return String.format("Name = %s, Price = $%.2f, Qty = %d", name, price, quantity);
    }

    private void verifyDouble(double num) {
        if(num < 0) {
           throw new IllegalArgumentException("Error: double value cannot be less than zero");
        }
    }

    private void verifyInt(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("Error: int value cannot be less than zero");
        }
    }


    private void verifyString(String str) {
        if(str.equals("") || str == null) {
            throw new IllegalArgumentException("Error: String cannot be empty or equal to null");
        }
    }
}
