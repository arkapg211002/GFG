//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {}
    static void fxn(int n,ArrayList<Integer> a,ArrayList<Integer> ar,int i){
        if(i>=a.size()) return;
        while (n%(a.get(i))==0) {
            ar.add(a.get(i));
            n /= a.get(i);
        }
        fxn(n, a, ar, i + 1);
    }
    static List<Integer> findPrimeFactors(int n) {
        // code here
        ArrayList<Integer> ar=new ArrayList<>();
        ArrayList<Integer> a=new ArrayList<>();
        boolean[] ans=new boolean[n+1];
        for(int i=2;i<=n;i+=1){
            ans[i]=true;
        }
        for(int i=2;i<=n;i++){
            if(ans[2]){
                int j=i+i;
                while(j<=n){
                    ans[j]=false;
                    j+=i;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(ans[i]){
                a.add(i);
            }
        }
        // System.out.println(a);
        fxn(n,a,ar,0);
        return ar;
    }
}
