//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int K = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.numOfSubsets(arr,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int fun(int index,int k,int arr[],int n)
   {
       if(index>=n)
       {
           if(k>0)return 1;
           else return 0;
       }
       int not_take=fun(index+1,k,arr,n);
       int take=0;
       if(arr[index]<=k)take=fun(index+1,k/arr[index],arr,n);
       return (take+not_take);
   }
  
    static int numOfSubsets(int arr[], int N, int K) 
    { 
        return fun(0,K,arr,N)-1;  //substracting 1 because we have to return the non empty subset 
    }
};