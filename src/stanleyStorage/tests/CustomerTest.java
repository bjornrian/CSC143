package stanleyStorage.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import stanleyStorage.Customer;

/**
 * Customers
 * Retrieve each attribute
 * update the customer’s name or phone number
 * Charge the customer a specified amount, or credit them a specified amount
 */
public class CustomerTest {

    @Test
    public void testGetAttributes() {
        Customer customer = buildCustomer();
        assertEquals("Bob", customer.getName());
        assertEquals("2341231234", customer.getPhone());
    }

    @Test
    public void testUpdateCustomerInfo() {
        Customer customer = buildCustomer();
        customer.setName("Janet");
        customer.setPhone("1234567890");
        assertEquals("Janet", customer.getName());
        assertEquals("1234567890", customer.getPhone());
    }

    @Test
    public void testChargeAmountToCustomer() {
        Customer customer = buildCustomer();
        customer.charge(200);
        assertEquals(200, customer.getBalance(), 0.0001);
    }

    @Test
    public void testCreditAmountToCustomer() {
        Customer customer = buildCustomer();
        customer.credit(200);
        assertEquals(-200, customer.getBalance(), 0.0001);
    }

    private Customer buildCustomer() {
        return new Customer("Bob", "2341231234");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVerifyAmount() {
        Customer customer = buildCustomer();
        customer.credit(-1);
    }
}
