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
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



//User function Template for Java

class Solution
{
    public double findProb(int N, int start_x, int start_y, int step)
    {
        // Code here
        if(step == 0) {
            return 1;
        }
        int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, 
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        double[][] dp = new double[N][N];
        dp[start_x][start_y] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start_x, start_y));
        double probability = 0;
        while(step != 0) {
            double[][] temp = new double[N][N];
            probability = 0;
            int size = queue.size();
            HashSet<Integer> set = new HashSet<>();
            while(size != 0) {
                Pair rem = queue.remove();
                if(dp[rem.i][rem.j] != 0) {
                    double toAdd = dp[rem.i][rem.j] / 8;
                    for(int[] dir : dirs) {
                        int x = rem.i + dir[0];
                        int y = rem.j + dir[1];
                        if(0 <= x && x < N && 0 <= y && y < N) {
                            temp[x][y] += toAdd;
                            probability += toAdd;
                            int hash = x * N + y;
                            if(!set.contains(hash)) {
                                set.add(hash);
                                queue.add(new Pair(x, y));
                            }
                        }
                    }
                }
                size--;
            }
            dp = temp;
            step--;
        }
        return probability;
    }
    
    private class Pair {
        int i;
        int j;
        
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}