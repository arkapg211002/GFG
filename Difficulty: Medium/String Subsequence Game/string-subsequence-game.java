//{ Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            TreeSet<String> ans = new TreeSet<String>();
            ans = ob.allPossibleSubsequences(S);
            Iterator it = ans.iterator();
            if (ans.size() == 0) {
                System.out.print(-1);
            } else
                while (it.hasNext()) {
                    System.out.print(it.next() + " ");
                }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function template for Java

class Solution {
    
    static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    
    static boolean isConso(char ch){
        if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
            return true;
        }
        return false;
    }
    
    
    
    static TreeSet<String> allPossibleSubsequences(String s) {
        
        int n = s.length();
        String res = "";
        TreeSet<String> set = new TreeSet<>();
        return solve(0, n, res, s, set);
    }
    
    static TreeSet<String> solve(int i, int n, String res, String str, TreeSet<String> set)
    {
        if(i==n)
        {
            if(res.length() != 0 && isVowel(res.charAt(0)) && isConso(res.charAt(res.length() -1)))
            {
                set.add(res);
            }
            return set;
        }
        
        solve(i+1, n, res, str, set);
        res += str.charAt(i);
        solve(i+1, n, res, str, set);
        
        return set;
    }
}