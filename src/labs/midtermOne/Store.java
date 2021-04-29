package labs.midtermOne;

import java.util.Iterator;

public class Store {
    public static void main(String[] args) {
        ArrayListStarter<Item> shelf1 = new ArrayListStarter<Item>(3);
        shelf1.add(0, new Item("supplies", "Puppy Paper Towels", 6.78, 43));
        shelf1.add(1, new Item("food", "Pat's Potato Chips", 3.99, 57));
        shelf1.add(2, new Item("household", "SoSturdy Storage Bin, small", 3.39, 11));
        for(Item myItem : shelf1) {
            System.out.println(myItem);
        }
        shelf1.shuffle();
        Iterator<Item> itemIterator = shelf1.iterator();
        while(itemIterator.hasNext()) {
            System.out.println(itemIterator.next());
        }
    }
}
