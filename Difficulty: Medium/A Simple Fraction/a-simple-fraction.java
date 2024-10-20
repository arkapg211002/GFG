//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int n, int d)
    {
        // code here
        
        StringBuilder ans = new StringBuilder(Integer.toString(n / d));
        
        int rem = n % d;
        if (rem == 0)  return ans.toString();
        
        ans.append('.');
        Map<Integer, Integer> m = new HashMap<>();
        
        while (rem != 0) {
            if (m.containsKey(rem)) {
                ans.insert(m.get(rem), "(");
                ans.append(')');
                break;
            } else {
                m.put(rem, ans.length());
                int temp = (rem * 10) / d;
                ans.append(temp);
                rem = (rem * 10) % d;
            }
        }
 
        return ans.toString();
        
    }
}