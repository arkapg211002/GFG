//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends


class Tri{
    int row;
    int col;
    int val;
    Tri(int r,int c,int v){
        row=r;
        col=c;
        val=v;
    }
}
class Solution
{
    static int[] findSmallestRange(int[][] arr,int n,int k)
    {
        //add your code here
        PriorityQueue<Tri> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        int len=Integer.MAX_VALUE;
        int s=-1;
        int e=-1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            pq.add(new Tri(i,0,arr[i][0]));
            max=Math.max(max,arr[i][0]);
        }
        min=pq.peek().val;
        
        while(pq.peek().col<n){
            if(max-min<len){
                len=max-min;
                s=min;
                e=max;
            }
            Tri t=pq.remove();
            if(t.col==n-1)return new int[]{s,e};
            pq.add(new Tri(t.row,t.col+1,arr[t.row][t.col+1]));
            
            max=Math.max(max,arr[t.row][t.col+1]);
            min=pq.peek().val;
            
        }
         return new int[]{s,e};
    }
}