//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
     public int editDistance(String s, String t) {
        // Code here
        int n=s.length();
        int m=t.length();
        int[][] memo=new int[n][m];
        for(int[] val:memo){
            Arrays.fill(val,-1);
        }
        return solve(n-1,m-1,s,t,memo);
    }
    
    // memoization
    public static int solve(int i,int j,String s,String t,int[][] memo){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(s.charAt(i)==t.charAt(j)){
            return 0+solve(i-1,j-1,s,t,memo);
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int insert=1+solve(i,j-1,s,t,memo);
        int remove=1+solve(i-1,j,s,t,memo);
        int replace=1+solve(i-1,j-1,s,t,memo);
        memo[i][j]=Math.min(Math.min(insert,remove),replace);
        return memo[i][j];
    }
}