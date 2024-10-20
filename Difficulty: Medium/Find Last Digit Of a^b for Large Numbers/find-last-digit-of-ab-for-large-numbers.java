//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            String a = S[0];
            String b = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getLastDigit(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getLastDigit(String a, String b) {
         // IF POWER VALUE IS 0 TO RETURN 1
        if(b.equals("0"))
            return 1;
        
        // TO FIND BASE VALUES :
        int num=a.charAt(a.length()-1)-'0';
        
        // POWER  OF VALUES LAST DIGIT FROM 0 - 9 : 
        int[][] cycles={
            {0},        //0
            {1},        //1
            {2,4,8,6},  //2
            {3,9,7,1},  //3
            {4,6},      //4
            {5},        //5
            {6},        //6
            {7,9,3,1},  //7
            {8,4,2,6},  //8
            {9,1},      //9
        };
        
        // TO FIND BASE OF POWER IN CYCLES
        int[] base=cycles[num];
        // TO FIND BASE OF POWER LENGTH 
        int base_length=base.length;
        
        // TO FIND LAST DIGIT OF INPUT
        int exponent=0;
        for(int i=0;i<b.length();i++)
        {
            exponent=(exponent*10+(b.charAt(i)-'0'))%base_length;
        }
        
        if(exponent==0)
            exponent=base_length;
            
        return base[exponent-1];
    }
};