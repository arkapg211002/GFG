//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static boolean isAnagram(Node root, int[] arr, int n) {
        int[] freq = arr.clone(); // Clone the array to avoid modifying the original

        while (root != null && n > 0) {
            freq[root.data - 'a']--;
            root = root.next;
            n--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) return false;
        }
        return true;
    }

    public static ArrayList<Node> findAnagrams(Node head, String str) {
        Node temp = head;
        int[] arr = new int[26];

        // Populate frequency array based on target string
        for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'a']++;

        ArrayList<Node> ans = new ArrayList<>();
        // Set<String> st = new HashSet<>();

        while (temp != null) {
            if (isAnagram(temp, arr, str.length())) {
                StringBuilder s = new StringBuilder();
                Node store = temp;
                Node prev=null;
                // Collect characters to check if this sequence is unique
                for (int i = 0; i < str.length() && temp != null; i++) {
                    s.append(temp.data);
                    prev=temp;
                    temp = temp.next;
                }

                ans.add(store);
                prev.next=null;
            } else {
                temp = temp.next;
            }
        }
        return ans;
    }
}