//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 
  
		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 
  
		String next(){ 
			while (st == null || !st.hasMoreElements()){ 
				try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
			} 
			return st.nextToken(); 
		} 
  
		String nextLine(){ 
			String str = ""; 
			try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
			return str; 
		} 
		
		int nextInt(){
		    return Integer.parseInt(next());
		}
	}
	
    public static void main(String args[])throws IOException
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i < n;i++)
                arr[i] = sc.nextInt();
            int q = sc.nextInt();
            int queries[] = new int[2*q];
            for(int i = 0;i < 2*q;i++)
                queries[i] = sc.nextInt();
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.querySum(n, arr, q, queries);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    int[] segmentTree;
    List<Integer> querySum(int n, int arr[], int q, int queries[]){
        segmentTree = new int[4 * n];
        
        // build segment tree
        buildSegmentTree(0, 0, n - 1, arr);
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0 ; i < 2 * q ; i += 2) {
            int start = queries[i] - 1;
            int end = queries[i + 1] - 1;
            res.add(query(start, end, 0, 0, n - 1));
        }
        return res;
    }
    
    int query(int start, int end, int i, int l, int r) {
        if (l > end || r < start) return 0;
        if (l >= start && r <= end) return segmentTree[i];
        
        int mid = (l + r) / 2;
        return query(start, end, 2 * i + 1, l, mid) 
                + query(start, end, 2 * i + 2, mid + 1, r);
    }
    
    void buildSegmentTree(int i, int l, int r, int arr[]) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        
        int mid = (l + r) / 2;
        buildSegmentTree(2 * i + 1, l, mid, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, arr);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
}