//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.kthDiff(a, n, k));
            
        
System.out.println("~");
}
	}
}


// } Driver Code Ends




//User function Template for Java


class Compute {
    
public long kthDiff(int arr[], int n, int k) {
        ArrayList<Integer> differences = new ArrayList<>();
        
        // Collect all absolute differences between pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                differences.add(Math.abs(arr[i] - arr[j]));
            }
        }
        
        // Sort the differences in ascending order
        Collections.sort(differences);
        
        // Check if we have at least k differences
        if (differences.size() >= k) {
            return differences.get(k - 1); // k-th smallest element is at index k-1
        }
        
        return -1;
}
}