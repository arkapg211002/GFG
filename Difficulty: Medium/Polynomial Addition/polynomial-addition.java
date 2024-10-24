//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int coeff;
    int pow;
    Node next;

    Node(int c, int p) {
        this.coeff = c;
        this.pow = p;
        this.next = null;
    }
}

class PolynomialUtils {

    // Method to append a new node to the linked list
    public static void append(Node[] head_ref, Node[] tail_ref, int new_data,
                              int new_data1) {
        Node new_node = new Node(new_data, new_data1);

        if (head_ref[0] == null) {
            head_ref[0] = new_node;
        } else {
            tail_ref[0].next = new_node;
        }
        tail_ref[0] = new_node;
    }

    // Method to print the polynomial
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.coeff + "x^" + temp.pow);
            if (temp.next != null) {
                System.out.print(" + ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class PolynomialAddition {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            Node[] poly1Head = {null};
            Node[] poly1Tail = {null};

            String[] input1 = br.readLine().trim().split(" ");
            for (int i = 0; i < input1.length; i += 2) {
                int coeff = Integer.parseInt(input1[i]);
                int pow = Integer.parseInt(input1[i + 1]);
                PolynomialUtils.append(poly1Head, poly1Tail, coeff, pow);
            }

            Node[] poly2Head = {null};
            Node[] poly2Tail = {null};

            String[] input2 = br.readLine().trim().split(" ");
            for (int i = 0; i < input2.length; i += 2) {
                int coeff = Integer.parseInt(input2[i]);
                int pow = Integer.parseInt(input2[i + 1]);
                PolynomialUtils.append(poly2Head, poly2Tail, coeff, pow);
            }

            Solution obj = new Solution();
            Node sum = obj.addPolynomial(poly1Head[0], poly2Head[0]);

            PolynomialUtils.printList(sum);
        }
    }
}

// } Driver Code Ends


/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

// Print the polynomial formed by adding both LL in the function itself.
class Solution {
    public static Node addPolynomial(Node head1, Node head2) {
        // Add your code here.
        Node ptr1=head1;
        Node ptr2=head2;
        Node head3=new Node(0,0);
        Node ptr3=head3;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.pow==ptr2.pow){
                ptr3.next=new Node(ptr1.coeff+ptr2.coeff,ptr1.pow);
                ptr1=ptr1.next;
                ptr2=ptr2.next;
            }
            else if(ptr1.pow<ptr2.pow){
                ptr3.next=new Node(ptr2.coeff,ptr2.pow);
                ptr2=ptr2.next;
            }
            else{
                ptr3.next=new Node(ptr1.coeff,ptr1.pow);
                ptr1=ptr1.next;
            }
            ptr3=ptr3.next;
        }
        while(ptr1!=null){
            ptr3.next=new Node(ptr1.coeff,ptr1.pow);
            ptr1=ptr1.next;
            ptr3=ptr3.next;
        }
        while(ptr2!=null){
            ptr3.next=new Node(ptr2.coeff,ptr2.pow);
            ptr2=ptr2.next;
            ptr3=ptr3.next;
        }
        return head3.next;
        
    }
}