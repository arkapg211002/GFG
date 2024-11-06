//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            

            Solution ob = new Solution();
            if(ob.is1winner(N,arr))
            System.out.println("1");
            else
            System.out.println("0");
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution {
    static Boolean is1winner(int N, int arr[]) {
        // Create a table to store solutions of subproblems
        int[][] dp = new int[N][N];

        // Fill the table
        for (int length = 1; length <= N; length++) {
            for (int i = 0; i <= N - length; i++) {
                int j = i + length - 1;
                // Initialize x, y and z to handle out of bounds conditions
                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;
                
                // Use the recurrence relation to fill dp[i][j]
                dp[i][j] = Math.max(arr[i] + Math.min(x, y),
                                    arr[j] + Math.min(y, z));
            }
        }
        
        // Player 1's score
        int player1 = dp[0][N - 1];
        
        // Total sum of all elements
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        
        // Player 2's score is the remaining sum
        int player2 = total - player1;
        
        // Player 1 wins if their score is greater than or equal to player 2
        return player1 >= player2;
    
        // code here
    }
}