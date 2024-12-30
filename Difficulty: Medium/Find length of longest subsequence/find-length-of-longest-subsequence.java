//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            String X = input_line[0];
            String Y = input_line[1];
            Solution obj = new Solution();
            int ans = obj.maxSubsequenceSubstring(X, Y, N, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends




//User function Template for Java
class Solution 
{ 
    int maxSubsequenceSubstring(String X, String Y, int N, int M) 
    {
        int max = 0;
        for(int i=0;i<=M;i++){
            int temp = helper(X,Y,N,i);
            max = Math.max(max,temp);
        }
        return max;
    }
    
    private int helper(String X,String Y,int N,int M){
        if(M==0 || N==0){
            return 0;
        }
        
        if(X.charAt(N-1)==Y.charAt(M-1)){
            return 1 + helper(X,Y,N-1,M-1);
        }else{
            return helper(X,Y,N-1,M);
        }
    }
} 