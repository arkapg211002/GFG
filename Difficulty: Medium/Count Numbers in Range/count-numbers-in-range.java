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
            String S[] = read.readLine().split(" ");
            
            Long L = Long.parseLong(S[0]);
            Long R = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.count3DivNums(L,R));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int count3DivNums(Long L, Long R) {
        // code here
        
        int limit =(int) Math.sqrt(R);
        
        int arr [] = new int [limit+1];
        
        
        for(int i=2;i<=limit;i++){
            arr[i]=1;
        }
        
        for(int j=2;j*j<=limit;j++){
            
            if(arr[j]==1){
                for(int k=j*j;k<=limit;k+=j){
                    arr[k]=0;
                }
            }
        }
        
        int count = 0;
        
        for(int i =2;i<=limit;i++){
            if(arr[i]==1){
                long square = (long) i*i;
                
                if(square>=L && square<=R){
                count++;
            }
            }
            
        }
        
        
        return count;
        
        
    }
};