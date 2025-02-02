//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking count of testcases
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            // taking count of number elements
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;

            // taking the value of the k
            int k = Integer.parseInt(sc.nextLine());
            // Creating an array of size n
            int arr[] = new int[n];

            // Inserting all the elements to the array
            for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(temp[i]);

            // calling kthSmallest method of class solve
            // and printing the result
            System.out.println(new Solution().kthSmallest(arr, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to find the kth smallest element in the array.
    public static int kthSmallest(int a[], int k) {
       PriorityQueue<Integer> p=new PriorityQueue<>();
    for(int i=0;i<a.length;i++)
    p.add(a[i]);
     while(k>1 && !p.isEmpty())
     {
         p.poll();
         k--;
     }
     return p.poll();
    }
}