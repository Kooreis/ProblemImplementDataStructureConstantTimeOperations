import java.util.*;

public class Main {
    public static void main(String[] args) {
        CustomDataStructure ds = new CustomDataStructure();
        ds.increment("apple");
        ds.increment("banana");
        ds.increment("apple");
        System.out.println(ds.getMaxKey());
        System.out.println(ds.getMinKey());
        ds.decrement("apple");
        System.out.println(ds.getMaxKey());
        System.out.println(ds.getMinKey());
    }
}