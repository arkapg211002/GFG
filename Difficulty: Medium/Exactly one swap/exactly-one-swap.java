//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.countStrings(S); 
            System.out.println(ans);
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends




//User function Template for Java

class Solution 
{   
    long countStrings(String S) 
    { 
        HashMap<Character, Integer> map = new HashMap<>();
        long sum = 0;
        
        // Step 1: Calculate frequency of each character
        for(int i = 0; i <= S.length() - 1; i++){
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        
        long n = (long) S.length();
        // Step 2: Calculate total possible swaps
        long ans = n * (n - 1) / 2;
        
        // Step 3: If all characters are distinct, return total swaps
        if (map.size() == S.length()) {
            return ans;
        } else {
            // Step 4: Calculate invalid swaps for repeated characters
            for (Character k : map.keySet()) {
                long p = map.get(k);
                sum += p * (p - 1) / 2;
            }  
        }
        
        // Step 5: Return total distinct strings
        return (ans - sum + 1); // Include the original string
    }
}

