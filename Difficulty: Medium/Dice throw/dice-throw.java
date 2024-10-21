//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M, N, X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static long getWays(int need,int dices,Map<Integer,Map<Integer,
    Long>> mp,int m){
        
        if(mp.containsKey(need) && mp.get(need).containsKey(dices))
            return mp.get(need).get(dices);
        else if(need==0){
            if(dices==0)
                return 1;
            else
                return 0;
        }
        else if(dices==0){
            return 0;
        }
        else{
            long count=0;
            for(int i=1;i<=m;++i){
                count+=getWays(need-i,dices-1,mp,m);
            }
            Map<Integer,Long> md = mp.getOrDefault(need,new HashMap<>());
            md.put(dices,count);
            mp.put(need,md);
            
            return mp.get(need).get(dices);
        }
    }
    
    static long noOfWays(int m, int n, int x) {
        
        Map<Integer,Map<Integer,Long>> mp = new HashMap<>();
        if(m>x)
            m=x;
        return getWays(x,n,mp,m);
        // code here
    }
};