//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        Arrays.sort(range, Comparator.comparingInt(a -> a[0]));

        ArrayList<int[]> list = new ArrayList<>();
        int start = range[0][0];
        int end = range[0][1];

        for (int i = 1; i < range.length; i++) {
            if (end >= range[i][0]) {
                end = Math.max(end, range[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = range[i][0];
                end = range[i][1];
            }
        }
        list.add(new int[]{start, end});

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];
            for (int j = 0; j < list.size(); j++) {
                int s = list.get(j)[0];
                int e = list.get(j)[1];
                int curr = e - s + 1;
                if (curr >= k) {
                    res.add(s + k - 1);
                    k = k - curr;
                    break;
                }
                k = k - curr;
            }
            if (k > 0) {
                res.add(-1);
            }
        }
        return res;
    }
}
        
