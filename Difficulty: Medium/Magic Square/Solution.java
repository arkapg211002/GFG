//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
        public static String magicSquare(int mat[][]) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns

        if (n != m) return "Not a Magic Square"; // Must be a square matrix

        int sum = 0; // Standard sum to check against
        for (int j = 0; j < m; j++) {
            sum += mat[0][j]; // Take the sum of the first row as reference
        }

        // Check for distinct numbers from 1 to n²
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(mat[i][j]);
            }
        }
        if (set.size() != n * n || !set.containsAll(range(1, n * n))) {
            return "Not a Magic Square";
        }

        // Check row sums
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += mat[i][j];
            }
            if (rowSum != sum) return "Not a Magic Square";
        }

        // Check column sums
        for (int j = 0; j < m; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += mat[i][j];
            }
            if (colSum != sum) return "Not a Magic Square";
        }

        // Check primary diagonal sum
        int diag1 = 0;
        for (int i = 0; i < n; i++) {
            diag1 += mat[i][i];
        }
        if (diag1 != sum) return "Not a Magic Square";

        // Check secondary diagonal sum
        int diag2 = 0;
        for (int i = 0; i < n; i++) {
            diag2 += mat[i][n - i - 1];
        }
        if (diag2 != sum) return "Not a Magic Square";

        return "Magic Square";
    }

    private static HashSet<Integer> range(int start, int end) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            set.add(i);
        }
        return set;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) mat[i][j] = sc.nextInt();
            }
            Solution sln = new Solution();
            String s = sln.magicSquare(mat);
            System.out.println(s);
        }
    }
}
// } Driver Code Ends
