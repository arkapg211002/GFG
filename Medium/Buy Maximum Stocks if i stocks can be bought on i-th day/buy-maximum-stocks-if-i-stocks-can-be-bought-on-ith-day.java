//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        Queue<int[]> pq=new PriorityQueue<>((x,y)->x[0]-y[0]);
        for(int i=0;i<n;i++) pq.add(new int[]{price[i],i+1});
        int total=0;
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            int j=p[1],currPrice=p[0];
            while(k>=currPrice && j-->0){
                k-=currPrice;
                total++;
            }
        }
        return total;
    }
}
        
