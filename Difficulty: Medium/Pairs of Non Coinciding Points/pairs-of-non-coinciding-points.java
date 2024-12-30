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
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        Map<Integer, Integer> xCount = new HashMap<>();
        Map<Integer, Integer> yCount = new HashMap<>();
        Map<ArrayList<Integer>, Integer> visited = new HashMap<>();
        int cnt1=0, cnt2=0, cnt3=0;
        for(int i=0;i<N;i++){
            cnt1+=xCount.getOrDefault(X[i], 0);
            xCount.put(X[i], xCount.getOrDefault(X[i],0)+1);
            
            cnt2+=yCount.getOrDefault(Y[i], 0);
            yCount.put(Y[i], yCount.getOrDefault(Y[i], 0)+1);
            
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(X[i], Y[i]));
            cnt3+=visited.getOrDefault(list, 0);
            visited.put(list, visited.getOrDefault(list, 0)+1);
        }
        return cnt1+cnt2-(2*cnt3);
    }
};