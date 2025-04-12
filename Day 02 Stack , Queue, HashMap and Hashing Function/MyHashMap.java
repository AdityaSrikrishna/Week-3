
public class MyHashMap {
    // Inner class to represent key-value pairs
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    // Put key-value pair
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // Update
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        curr.next = new Node(key, value); // Insert new
    }

    // Get value by key
    public int get(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1; // Not found
    }

    // Remove key
    public void remove(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    // Test the hash map
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(2, 20);
        System.out.println("Get 1: " + map.get(1)); // 10
        System.out.println("Get 3: " + map.get(3)); // -1

        map.put(2, 25); // Update value
        System.out.println("Get 2: " + map.get(2)); // 25

        map.remove(2);
        System.out.println("Get 2 after removal: " + map.get(2)); // -1
    }
}
