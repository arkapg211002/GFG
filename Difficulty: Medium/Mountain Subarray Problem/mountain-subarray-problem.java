//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Pair {
    int l, r;
    Pair(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            int q = Integer.parseInt(br.readLine().trim());
            ArrayList<Pair> queries = new ArrayList<Pair>();
            for (int i = 0; i < q; i++) {
                String[] lr = br.readLine().trim().split(" ");
                queries.add(
                    new Pair(Integer.parseInt(lr[0]), Integer.parseInt(lr[1])));
            }
            Solution sln = new Solution();

            ArrayList<Boolean> al = sln.processQueries(a, n, queries, q);
            for (boolean u : al) {
                if (u) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



// User function Template for Java

// refer Pair class in driver code
class Solution {
    public ArrayList<Boolean> processQueries(int[] a, int n, ArrayList<Pair> queries,
                                      int q) {
        // code here
        ArrayList<Boolean> res = new ArrayList<>(q);
        for(int j=0; j<q; j++){
            int firstidx = queries.get(j).l;
            int lastidx = queries.get(j).r;
            boolean found = false;
            boolean added = false;
            for(int k=firstidx; k<lastidx; k++){
                if(!found && a[k] > a[k+1]){
                    found = true;
                }
                else if(found && a[k] < a[k+1]){
                    res.add(false);
                    added = true;
                    break;
                }
            }
            if(!added){
                res.add(true);
            }
        }
        return res;
    }
}