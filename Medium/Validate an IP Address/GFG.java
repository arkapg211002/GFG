// https://www.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1

//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    public boolean isValid(String str) {
        
        String[] ip = str.split("\\.");
        
        if(ip.length != 4) return false;
        
        for(int i = 0; i < 4; i++){
            if(!(Integer.parseInt(ip[i] )<= 255 && Integer.parseInt(ip[i]) >=0)) return false;
        }
        
        
        return true;
    }
}
