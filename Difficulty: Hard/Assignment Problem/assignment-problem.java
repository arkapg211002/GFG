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
            String S[] = read.readLine().split(" ");
            
            int[] Arr = new int[N*N];
            
            for(int i=0; i<N*N; i++)
                Arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.assignmentProblem(Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int assignmentProblem(int Arr[], int N) {
        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = Arr[i * N + j];
            }
        }
        return hungarianAlgorithm(cost, N);
    }
    
    public static int hungarianAlgorithm(int[][] cost, int N) {
        int[] u = new int[N + 1];
        int[] v = new int[N + 1];
        int[] p = new int[N + 1];
        int[] way = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            p[0] = i;
            int j0 = 0;
            int[] minv = new int[N + 1];
            boolean[] used = new boolean[N + 1];
            Arrays.fill(minv, Integer.MAX_VALUE);
            do {
                used[j0] = true;
                int i0 = p[j0];
                int delta = Integer.MAX_VALUE, j1 = 0;
                for (int j = 1; j <= N; ++j) {
                    if (!used[j]) {
                        int cur = cost[i0 - 1][j - 1] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }
                for (int j = 0; j <= N; ++j) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }
                j0 = j1;
            } while (p[j0] != 0);

            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }
        return -v[0];
    }
};




