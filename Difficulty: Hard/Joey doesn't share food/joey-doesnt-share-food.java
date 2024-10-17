//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] nums = new int[n][6];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < 6; j++)
                    nums[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.MaxmimumLength(nums);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    private static final int MAX = 1000010;

    private long iter;
    private long[] was = new long[MAX];
    private int[] pa = new int[MAX], pb;
    private List<Integer>[] g = new ArrayList[MAX];

    // Constructor to initialize the graph structure
    public Solution() {
        for (int i = 0; i < MAX; i++) {
            g[i] = new ArrayList<>();
        }
    }

    // Function to initialize data
    public void initialize(int n, int[][] input) {
        for (int i = 0; i < MAX; i++) {
            g[i].clear();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                g[input[i][j]].add(i);
            }
        }
        for (int i = 0; i < MAX; i++) {
            Collections.shuffle(g[i]);
        }
    }

    // Iterative depth-first search function
    public boolean dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            was[curr] = iter;

            for (int j : g[curr]) {
                if (pb[j] == -1) {
                    pa[curr] = j;
                    pb[j] = curr;
                    return true;
                }
            }

            for (int j : g[curr]) {
                if (was[pb[j]] != iter) {
                    stack.push(pb[j]);
                }
            }
        }

        return false;
    }

    // Main function to calculate the maximum length
    public int MaxmimumLength(int[][] input) {
        int n = input.length;
        initialize(n, input);

        Arrays.fill(pa, -1);
        pb = new int[n];
        Arrays.fill(pb, -1);
        Arrays.fill(was, -1);

        int ans = 0;
        int rr = 0;
        iter = 0;

        for (int ll = 1; ll < MAX; ll++) {
            rr = Math.max(rr, ll - 1);

            // Try to extend rr as far as possible
            while (true) {
                iter++;
                if (dfs(rr + 1)) {
                    rr++;
                } else {
                    break;
                }
            }

            // Update the maximum length found
            ans = Math.max(ans, rr - ll + 1);

            // Reset pb[] and pa[] for the current `ll`
            if (pa[ll] != -1) {
                pb[pa[ll]] = -1;
                pa[ll] = -1;
            }
        }

        return ans;
    }
}



