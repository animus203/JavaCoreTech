package treeSet;

import java.util.TreeSet;

//树集，有序集合，内部使用红黑树
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 135));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);
    }
}
