//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{

    public static int getFirstSetBit(int n){
            
         String binary=Integer.toBinaryString(n);
         for(int i=binary.length()-1;i>=0;i--){
             if(binary.charAt(i) == '1'){
                 return binary.length()-i;
             }
         }
         return 0;
            
    }
}
