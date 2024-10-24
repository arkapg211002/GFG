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
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        if(9*D <= S){
            return "-1";
        }
        int[] arr = new int[D];
        
        int sum = 0;
        for(int i = 0 ; i < D; i++){
            for(int j = 9 ; j >= 0; j--){
                int val = sum+j;
                if(val <= S){
                arr[D-i-1] = j;
                sum += j;
                break;
                }
            }
        }
        if(arr[0] == 0){
            for(int i = 1; i < D; i++){
                if(arr[i] > 0){
                    arr[i]--;
                    arr[0] = 1;
                    break;
                }
            }
        }
        int p1 = D-1;
        int p2 = D-2;
        while(p2 >= 0){
            if(arr[p1] == 9 && arr[p2] == 9){
                p1--;
                p2--;
            }
            else{
                arr[p1]--;
                arr[p2]++;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < D; i++){
            sb.append(arr[i]);
        }
        String ans = sb.toString();
        return ans;
    }
}

