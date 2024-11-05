//{ Driver Code Starts
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        this.next = null;
        this.prev = null;
    }
}

public class Main {
    public static void push(DLLNode[] headRef, DLLNode[] tailRef, int new_data) {
        DLLNode newNode = new DLLNode(new_data);

        newNode.next = null;

        if (tailRef[0] != null) {
            newNode.prev = tailRef[0];
            tailRef[0].next = newNode;
        } else {
            headRef[0] = newNode;
            newNode.prev = null;
        }

        tailRef[0] = newNode;
    }

    public static void printList(DLLNode head) {
        if (head == null) return;

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = scanner.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            DLLNode[] head = {null}, tail = {null};
            for (int num : arr) {
                push(head, tail, num);
            }

            Solution obj = new Solution();
            head[0] = obj.quickSort(head[0]);
            printList(head[0]);
            System.out.println();
        }
        scanner.close();
    }
}

// } Driver Code Ends




/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public DLLNode quickSort(DLLNode head)
    {
      DLLNode curr = head;
      ArrayList<Integer> li = new ArrayList<>();
     while(curr!=null)
      {
          li.add(curr.data);
          curr = curr.next;
          
      }
      Collections.sort(li);
      curr = head;
      int i=0;
      while(i<li.size())
      {
          curr.data = li.get(i++);
          curr = curr.next;
      }
      return head;
    }
}