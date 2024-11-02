//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int minimumSum(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        
        // Step 1: Make sure the string can be a palindrome
        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            
            if (str[i] == '?' && str[j] == '?') {
                // Both are '?' - leave them for now
                continue;
            } else if (str[i] == '?') {
                // Replace '?' on the left with the right side character
                str[i] = str[j];
            } else if (str[j] == '?') {
                // Replace '?' on the right with the left side character
                str[j] = str[i];
            } else if (str[i] != str[j]) {
                // Mismatch that cannot be corrected - return -1
                return -1;
            }
        }

        // Step 2: Calculate the minimum ASCII sum
        int sum = 0;
        char prev = '\0';  // Track the previous character
        
        for (int i = 0; i < n; i++) {
            if (str[i] != '?') {
                // If prev is set (not '\0'), calculate the difference with the current character
                if (prev != '\0') {
                    sum += Math.abs(str[i] - prev);
                }
                prev = str[i];  // Update prev to the current character
            }
        }

        return sum;
    }
}