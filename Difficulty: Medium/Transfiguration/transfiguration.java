//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transfigure (A, B));
                
System.out.println("~");
}
        }
}
// } Driver Code Ends




//User function Template for Java


class Solution {
    int transfigure(String A, String B) {
        if (A.length() != B.length()) {
            return -1;
        }
        
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        
        if (!Arrays.equals(arrA, arrB)) {
            return -1;
        }
        
        int i = A.length() - 1;
        int j = B.length() - 1;
        int count = 0;

        while (i >= 0 && j >= 0) {
            if (A.charAt(i) != B.charAt(j)) {
                count++;
                i--;
            } else {
                i--;
                j--;
            }
        }
        
        return count;
    }
}