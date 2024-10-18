//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        
        Set<String>ans = new TreeSet<>();
        solve(0, new StringBuilder(S),ans);
        return new ArrayList<>(ans);
        
    }
    
    private void solve (int ind,StringBuilder sb ,Set<String> ans){
        if(ind == sb.length())
        {
            ans.add(sb.toString());
            return;
        }
        
         for(int i=ind;i<sb.length();i++){
            swap(sb, ind , i);
            solve(ind + 1 , sb, ans);
            swap(sb, ind, i);
        }
    }
    
    private void swap(StringBuilder sb, int i, int j)
    {
        char temp = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
    }
}