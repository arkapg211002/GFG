//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            ArrayList<Integer> ans = new Solution().repeatedRows(arr, n, m);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i)+" ");
                
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        // Set to store the string representation of each row
        HashSet<String> rowSet = new HashSet<>();

        // List to store the row numbers containing duplicate rows
        ArrayList<Integer> result = new ArrayList<>();

        // Traverse through each row
        for (int i = 0; i < m; i++) {
            // String representation of the current row
            String rowString = arrayToString(matrix[i]);

            // Check if the current row string already exists in the set
            if (!rowSet.add(rowString)) {
                // If yes, add the current row number to the result list
                result.add(i);
            }
        }

        // Return the list of row numbers containing duplicate rows
        return result;
    }

    // Helper method to convert array to string
    private static String arrayToString(int[] arr) {
        StringBuilder rowString = new StringBuilder();
        for (int num : arr) {
            rowString.append(num);
        }
        return rowString.toString();
    }
}