//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int indexDifference;
            indexDifference = Integer.parseInt(br.readLine());

            int valueDifference;
            valueDifference = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            boolean res =
                obj.closestSimilarElements(n, arr, indexDifference, valueDifference);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends






class Solution {
    public static boolean closestSimilarElements(int n, int[] arr, int indexDifference,
                                                 int valueDifference) {
        // code here
        
        int i=0,j=arr.length-1;
        
        while(i<j) {
            if(i-j<=indexDifference && arr[i]-arr[j]<=valueDifference)
                return true;
            else  {
                i++;
                j--;
            }
        }
        
        return false;
    }
}