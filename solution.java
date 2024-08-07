Here is a Java console application that implements a data structure supporting increment, decrement, getMaxKey, and getMinKey operations in constant time. This solution uses a HashMap to store keys and their counts, and a doubly linked list to maintain the order of counts. 

```java
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

class CustomDataStructure {
    private Node head, tail;
    private Map<String, Node> countNodeMap;
    private Map<String, Integer> keyCountMap;

    public CustomDataStructure() {
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.countNodeMap = new HashMap<>();
        this.keyCountMap = new HashMap<>();
        this.countNodeMap.put(0, this.head);
    }

    public void increment(String key) {
        int count = keyCountMap.getOrDefault(key, 0);
        keyCountMap.put(key, count + 1);
        if (countNodeMap.containsKey(count)) {
            countNodeMap.get(count).keys.remove(key);
        }
        if (!countNodeMap.containsKey(count + 1)) {
            Node newNode = new Node(count + 1);
            Node oldNode = countNodeMap.get(count);
            newNode.next = oldNode.next;
            newNode.prev = oldNode;
            oldNode.next.prev = newNode;
            oldNode.next = newNode;
            countNodeMap.put(count + 1, newNode);
        }
        countNodeMap.get(count + 1).keys.add(key);
        if (countNodeMap.get(count).keys.isEmpty()) {
            remove(countNodeMap.get(count));
        }
    }

    public void decrement(String key) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count - 1);
        if (countNodeMap.containsKey(count)) {
            countNodeMap.get(count).keys.remove(key);
        }
        if (count > 1) {
            countNodeMap.get(count - 1).keys.add(key);
        }
        if (countNodeMap.get(count).keys.isEmpty()) {
            remove(countNodeMap.get(count));
        }
    }

    public String getMaxKey() {
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next.keys.iterator().next();
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        countNodeMap.remove(node.count);
    }
}

class Node {
    int count;
    Set<String> keys;
    Node prev, next;

    public Node(int count) {
        this.count = count;
        this.keys = new LinkedHashSet<>();
    }
}
```