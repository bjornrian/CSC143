package stanleyStorage;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Customers
 * Retrieve each attribute
 * update the customer’s name or phone number
 * Charge the customer a specified amount, or credit them a specified amount
 */
public class CustomerTest {

    @Test
    public void testGetAttributes() {
        Customer myCust = getCustomer();
        assertEquals("Bob", myCust.getName());
        assertEquals("2341231234", myCust.getPhone());
    }

    @Test
    public void testUpdateCustomerInfo() {
        Customer myCust = getCustomer();
        myCust.setName("Janet");
        myCust.setPhone("1234567890");
        assertEquals("Janet", myCust.getName());
        assertEquals("1234567890", myCust.getPhone());
    }

    @Test
    public void testChargeAmountToCustomer() {
        Customer myCust = getCustomer();
        myCust.charge(200);
        assertEquals(200, myCust.getBalance(), 0.0001);
    }

    @Test
    public void testCreditAmountToCustomer() {
        Customer myCust = getCustomer();
        myCust.credit(200);
        assertEquals(-200, myCust.getBalance(), 0.0001);
    }

    private Customer getCustomer() {
        return new Customer("Bob", "2341231234");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVerifyAmount() {
        Customer testCustomer = new Customer("Bob", "10232842");
        testCustomer.credit(-1);
    }
}
