//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            Solution obj = new Solution();
            obj.radixSort(arr, n);
            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
                
            System.out.println();
        
System.out.println("~");
}
    }
}


// } Driver Code Ends




//User function Template for Java


class Solution
{
    static void radixSort(int arr[], int n) 
    { 
        // code here 
        int max=Integer.MIN_VALUE;
        for(int val:arr) max=Math.max(max,val);
        int exp=1;
        while(exp<=max){
            countSort(arr,exp);
            exp=exp*10;
        }
    } 
    static void countSort(int[] arr,int exp){
        int n=arr.length;
        int[] freq=new int[10];
        for(int val:arr){
            freq[val/exp%10]++;
        }
        freq[0]--;
        for(int i=1;i<freq.length;i++){
            freq[i]=freq[i-1]+freq[i];
        }
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            int val=arr[i];
            int idx=freq[val/exp%10];
            ans[idx]=val;
            freq[val/exp%10]--;
        }
        for(int i=0;i<n;i++){
            arr[i]=ans[i];
        }
    }
}











