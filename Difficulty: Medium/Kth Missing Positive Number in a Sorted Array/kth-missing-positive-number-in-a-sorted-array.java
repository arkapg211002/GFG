//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int kthMissing(int[] a, int k) {
        int i = 0, next = 1, n = a.length;
        
        while(i < n && k > 0){
            if(a[i] == next){
                next++;
                i++;
            }else{
                next++;
                k--;
            }
        }
        
        if(k == 0)
            return next - 1;
        
        // Now it means k is sill left and array is over
        // return last element of array plus k
        return a[n - 1] + k;
    }
}