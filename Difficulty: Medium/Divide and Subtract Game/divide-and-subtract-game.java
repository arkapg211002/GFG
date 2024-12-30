//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.divAndSub(N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution {
    static String divAndSub(int N) {
         if(N==1)
         return "Arya" ;
          
          int game[] = new int[N+1] ;
          game[0] = 0 ;
          
          for(int i = 1;i<=N;i++)
          {
              game[i] = 0 ;
              for(int move = 2;move<=5;move++)
              {
                  if(game[i/move]==0)
                  game[i] = 1 ;
                  if(i-move>=0 && game[i-move]==0)
                  game[i] = 1;
              }
          }
          if(game[N]==1)
          return "Jon";
          return "Arya";
    }
};