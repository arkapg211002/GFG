//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// design the class in the most optimal way

class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    static int capacity;
    static DoubleNode head = new DoubleNode(0, 0);
    static DoubleNode tail = new DoubleNode(0, 0);
    static HashMap<Integer, DoubleNode> map;
    
    LRUCache(int cap) {
       capacity = cap;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
         if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            delete(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
      if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            delete(node);
            node.value = value;
            insert(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(head.next.key);
                delete(head.next);

            }
            DoubleNode newNode = new DoubleNode(key, value);
            insert(newNode);
            map.put(key, newNode);
        }
    }
    static void insert(DoubleNode node) {
        DoubleNode prev = tail.prev;
        prev.next = node;
        node.next = tail;
        node.prev = prev;
        tail.prev = node;
    }
    static void delete(DoubleNode current) {
        DoubleNode prev = current.prev;
        DoubleNode next = current.next;
        prev.next = next;
        next.prev = prev;
    }
}
class DoubleNode {
    int key;
    int value;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
