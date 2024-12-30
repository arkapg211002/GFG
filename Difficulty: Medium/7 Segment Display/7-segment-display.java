//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.sevenSegments(S,N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static String sevenSegments(String S, int N) {
        if(N==1 && S.charAt(0)=='8')
        return ""+'8';
        // code here
        int sum=0;
        for(int i=0;i<N;i++){
            
            if(S.charAt(i)=='0')
            sum=sum+6;
            
            else if(S.charAt(i)=='1')
            sum=sum+2;
            
            else if(S.charAt(i)=='2')
            sum=sum+5;
            else if(S.charAt(i)=='3')
            sum=sum+5;
            else if(S.charAt(i)=='4')
            sum=sum+4;
            
            else if(S.charAt(i)=='5')
            sum=sum+5;
            
            else if(S.charAt(i)=='6')
            sum=sum+6;
            
            if(S.charAt(i)=='7')
            sum=sum+3;
            
            if(S.charAt(i)=='8')
            sum=sum+7;
            
            if(S.charAt(i)=='9')
            sum=sum+5;
            
            
            
            
            
            
        }
        //System.out.println(sum);
        
        String ans="";
        
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(6,0);
        hm.put(2,1);
        hm.put(5,2);
        hm.put(4,4);
        hm.put(3,7);
        hm.put(7,8);
        
       // System.out.println(sum);
        
        
        
        
        int[]dp=new int[N];
        for(int i=0;i<N;i++){
            dp[i]=1;
        }
        
        sum=sum-(2*N);
        
        
        
        for(int i=0;i<N;i++){
            
            if(sum>=4)
            {
                dp[i]=0;
                sum=sum-4;
            }
            
            else{
                break;
            }
        }
        
        
        int tm=N-1;
        
        while(sum>0){
            
            if(sum>=6){
               dp[tm]=8;
               sum=sum-6;
               tm=tm-1;
            }
            
            else{
                
                dp[tm]=hm.get(sum+2);
                break;
            }
        }
        
        
        for(int i=0;i<N;i++){
            ans=ans+""+dp[i];
        }
        
        
        
        
        return ans;
        
    }
};