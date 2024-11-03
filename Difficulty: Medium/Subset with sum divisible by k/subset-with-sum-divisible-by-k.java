//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.DivisibleByM(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
   static boolean modularSum(int arr[], 
                                int n, int m)
    {
        if (n > m)
            return true;
     
        // This array will keep track of all
        // the possible sum (after modulo m)
        // which can be made using subsets of arr[]
        // initialising boolean array with all false
        boolean DP[]=new boolean[m];
         
        Arrays.fill(DP, false);
     
        // we'll loop through all the elements
        // of arr[]
        for (int i = 0; i < n; i++)
        {
             
            // anytime we encounter a sum divisible
            // by m, we are done
            if (DP[0])
                return true;
     
            // To store all the new encountered sum
            // (after modulo). It is used to make 
            // sure that arr[i] is added only to 
            // those entries for which DP[j] 
            // was true before current iteration. 
            boolean temp[] = new boolean[m];
            Arrays.fill(temp, false);
     
            // For each element of arr[], we loop 
            // through all elements of DP table 
            // from 1 to m and we add current 
            // element i. e., arr[i] to all those 
            // elements which are true in DP table
            for (int j = 0; j < m; j++)
            {
                 
                // if an element is true in 
                // DP table
                if (DP[j] == true)
                {
                    if (DP[(j + arr[i]) % m] == false)
     
                        // We update it in temp and update
                        // to DP once loop of j is over
                        temp[(j + arr[i]) % m] = true;
                }
            }
     
            // Updating all the elements of temp
            // to DP table since iteration over
            // j is over
            for (int j = 0; j < m; j++)
                if (temp[j])
                    DP[j] = true;
     
     
            // Also since arr[i] is a single 
            // element subset, arr[i]%m is one 
            // of the possible sum
            DP[arr[i] % m] = true;
        }
     
        return DP[0];
    }

    public int DivisibleByM(int[] arr, int k) {
        // Call the recursive function with memoization
        if (modularSum(arr,arr.length,k)) {
            return 1;
        }
        return 0;
    }
}