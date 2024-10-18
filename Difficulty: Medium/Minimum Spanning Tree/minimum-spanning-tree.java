//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int spanningTree(int v, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] mst = new boolean[v];
        
        int[] key = new int[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        
        key[0] = 0;
        int i = 0;
        while(i < v){
            int min = Integer.MAX_VALUE;
            int u = 0;
            for(int j=0;j<v;j++){
                if(!mst[j] && min > key[j]){
                    min = key[j];
                    u = j;
                }
            }
            mst[u] = true;
            for(int[] arr : adj.get(u)){
                if(!mst[arr[0]] && key[arr[0]] > arr[1]){
                    key[arr[0]] = arr[1];
                }
            }
            i++;
        }
        int ans = 0;
        for(int k:key){
            ans += k;
        }
        return ans;
    }
}