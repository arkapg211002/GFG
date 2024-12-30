//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());
            
            Solution ob = new Solution();
            
            ArrayList<Long> answer = ob.absDifOne(n);
            
            for(long value :  answer){
                System.out.print(value+" ");
            }
            
            if(answer.size() == 0)
            System.out.print(-1);
            
            System.out.println();

        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    ArrayList<Long> absDifOne(long N){
        
        ArrayList<Long> ans = new ArrayList<>();
        
        if(N<=9){
            ans.add((long)-1);
            return ans;
        }
        
        for(long i =1;i<=9;i++){
            helper(i,N,ans);
        }
        Collections.sort(ans);
        return ans;
    }
    
    public void helper(long value, long N, ArrayList<Long> ans ){
        if(value>N){
            return;
        }
        
        if(value>=10 && value<=N){
            ans.add(value);
        }
        
        long back= value%10;
    // explore previous adjacent
        if((back)!=0){
        helper(value*10+(back-1),N,ans);
        }
    // explore next adjacent
        if(back!=9){
        helper(value*10+(back+1),N,ans);
        }
    }
    
}