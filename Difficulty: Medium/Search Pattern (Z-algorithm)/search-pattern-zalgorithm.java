//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            if(res.size()==0)
                System.out.print("-1 ");
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 1: Create the concatenated string
        String combined = pat + "$" + S;
        
        // Step 2: Compute the Z-array for the concatenated string
        int[] Z = computeZArray(combined);
        
        // Step 3: Find all matches of the pattern in the text
        int patLen = pat.length();
        for (int i = patLen + 1; i < Z.length; i++) {
            if (Z[i] == patLen) {
                result.add(i - patLen); // Convert to 1-based index
            }
        }
        
        return result;
    }

    // Helper function to compute the Z-array
    private static int[] computeZArray(String str) {
        int n = str.length();
        int[] Z = new int[n];
        int left = 0, right = 0;
        
        for (int i = 1; i < n; i++) {
            if (i <= right) {
                Z[i] = Math.min(right - i + 1, Z[i - left]);
            }
            while (i + Z[i] < n && str.charAt(Z[i]) == str.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > right) {
                left = i;
                right = i + Z[i] - 1;
            }
        }
        
        return Z;
    }
}