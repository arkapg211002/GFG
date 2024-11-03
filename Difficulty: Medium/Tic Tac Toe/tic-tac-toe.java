//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            char[] board = new char[9];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < 9; i++) {
                board[i] = inputLine[i].charAt(0);
            }
            boolean ans = new Solution().isValid(board);
            System.out.println(ans ? "Valid" : "Invalid");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends





class Solution {
    boolean isValid(char[] ar) {
        int i,j,x=0,o=0;
        for(i=0;i<9;i++){
            if(ar[i]=='X')
                x+=1;
        }
        if(x!=5)
            return false;
        x=0;
        if(ar[0]=='X' && ar[4]=='X' && ar[8]=='X') 
            x+=1;
        if(ar[2]=='X' && ar[4]=='X' && ar[6]=='X')
            x+=1;
        if(ar[0]=='O' && ar[4]=='O' && ar[8]=='O') 
            o+=1;
        if(ar[2]=='O' && ar[4]=='O' && ar[6]=='O')
            o+=1;
        for(i=0,j=0;i<=2;i++,j+=3){
            if(ar[i]=='X' && ar[i+3]=='X' && ar[i+6]=='X')
                x+=1;
            if(ar[i]=='O' && ar[i+3]=='O' && ar[i+6]=='O')
                o+=1;
            if(ar[j]=='X' && ar[j+1]=='X' && ar[j+2]=='X')
                x+=1;
            if(ar[j]=='O' && ar[j+1]=='O' && ar[j+2]=='O')
                o+=1;
        }
        if(x>1 || o>1 || (x>0 && o>0))
            return false;
        else
            return true;
        
    }
}