//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = "", p = "";
            s = sc.next();
            p = sc.next();

            Solution obj = new Solution();

            if (obj.search(p, s) == true)
                System.out.println("Yes");
            else
                System.out.println("No");
        
System.out.println("~");
}
    }
}
// } Driver Code Ends





class Solution {
    // Function to check if the given pattern exists in the given string or not.
    static boolean search(String pat, String txt) {
        int n = pat.length();
        int[] lps = new int[n];
        Arrays.fill(lps, 0);
        computeLPS(pat, n, lps);
        int i=0; int j =0;
        int m = txt.length();
        while(i < m){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == n){
                    return true;
                }
            }else {
                if(j > 0 ){
                    j = lps[j-1];
                }else {
                    i++;
                }
            }
        }
        return false;
    }
    
    public static void computeLPS(String pat,int n, int[] lps){
        int start = 1;
        int len = 0;
        lps[0] = 0;
        while(start < n){
            if(pat.charAt(start) == pat.charAt(len)){
                len++;
                lps[start]=len;
                start++;
            }else {
                if(len > 0){
                    len = lps[len-1];
                }else {
                    lps[start] = 0;
                    start++;
                }
            }
        }
    }
}