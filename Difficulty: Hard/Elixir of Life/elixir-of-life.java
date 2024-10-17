//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String str = sc.next();
                 
                    Sol obj = new Sol();
                    System.out.println(obj.maxFrequency(str));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol {
    int maxFrequency(String S) {
        int ans = 0;
        int n = S.length();
        String temp = "";
        
        // Find the longest prefix which is also a suffix
        for (int i = 0; i < n; i++) {
            String s1 = S.substring(0, i + 1);
            String s2 = S.substring(n - i - 1, n);
            if (s1.equals(s2)) {
                temp = s1;
                break;
            }
        }

        // Count the frequency of the found substring temp in the main string S
        int len = temp.length();
        for (int i = 0; i <= n - len; i++) {
            if (S.substring(i, i + len).equals(temp)) {
                ans++;
            }
        }
        
        return ans ; // Subtract 1 because we start ans at 1 initially
    }
}