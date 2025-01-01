//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            Solution ob = new Solution();
            System.out.println(ob.isPart(n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution{
    public static boolean isPrime(int n){
        if(n<2) return false;
        for(int i =2; i*i<=n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    
    static String isPart(int n){
        //complete the function here
        if(isPrime(n+2)) return "Yes";
        return "No";
    }
}