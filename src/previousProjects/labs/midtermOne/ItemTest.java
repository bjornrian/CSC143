package previousProjects.labs.midtermOne;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Items
 * -Test full constructor
 * -Test pertinent accessor methods
 * -Test constructor's preconditions
 */
public class ItemTest {

    @Test
    public void testConstructorAndAccessors() {
        Item testItem = new Item("Furniture", "Teak Table", 100.89, 3);
        assertEquals("Furniture" ,testItem.getCategory());
        assertEquals("Teak Table", testItem.getName());
        assertEquals(100.89 , testItem.getPrice(), 0.001);
        assertEquals(3, testItem.getQuantity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPreconditions() {
        Item testItem = new Item("", null, -99.99, -12);
    }
}
