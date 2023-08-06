//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends




/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a



class Solution
{
    // Function to merge K sorted linked lists.
    Node mergeKList(Node[] arr, int K)
    {
        // Create a priority queue to store nodes in a sorted manner based on their values.
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the head nodes of all K linked lists to the priority queue.
        for (int i = 0; i < K; i++) {
            if (arr[i] != null) {
                minHeap.offer(arr[i]);
            }
        }

        // Create a dummy node to build the merged list.
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Merge the linked lists by extracting the nodes with the smallest value from the priority queue.
        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummy.next;
    }
}