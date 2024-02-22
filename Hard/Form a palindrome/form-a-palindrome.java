//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
       String str1 = new StringBuilder(str).reverse().toString();
       int n=str.length();
       int dp[][]=new int[n+1][n+1];
       for(int i=0;i<n+1;i++){
           for(int j=0;j<n+1;j++){
               if(i==0||j==0){
                   dp[i][j]=0;
               }
               else if(str.charAt(i-1)==str1.charAt(j-1)){
                   dp[i][j]=1+dp[i-1][j-1];
               }
               else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
               
           }
           
       }
       int last=dp[n][n];
       return n-last;
    }
}