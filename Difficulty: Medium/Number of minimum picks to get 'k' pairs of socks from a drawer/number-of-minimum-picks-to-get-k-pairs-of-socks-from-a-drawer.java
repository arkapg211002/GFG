//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n, k, ans;
            n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            k = sc.nextInt();
            Solution obj = new Solution();
            ans = obj.find_min(a, n, k);
            System.out.println(ans);
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends





// User function Template for Java

class Solution {
    public int find_min(int[] a, int n, int k) {
        // code here.
int p=0;int sum=0;
       for(int i=0;i<n;i++){
           p+=a[i]/2;
           if(a[i]%2==0){
               sum+=(a[i]-2)/2;
           }else{
               sum+=(a[i]-1)/2;
           }
       }
       if(p<k){
           return -1;
       }else if(sum>=k){
           return (2*(k-1))+n+1;
       }else{
           return (2*sum)+n+(k-sum);
    }
}}