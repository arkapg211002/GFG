//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// avoid space at the starting of the string in "move disk....."
class Hanoi {

    public long toh(int n, int from, int to, int aux) {
        if (n == 1) {
            System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
            return 1;
        }

        long count = 0;
        // Move (n-1) disks from 'from' to 'aux'
        count = toh(n - 1, from, aux, to);
        
        // Move nth disk from 'from' to 'to'
        System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
        count++;
        
        // Move (n-1) disks from 'aux' to 'to'
        count += toh(n - 1, aux, to, from);
        
        return count;
    }
}


