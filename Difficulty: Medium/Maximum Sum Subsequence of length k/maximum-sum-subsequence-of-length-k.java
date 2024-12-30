//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine();
            String[] S  =s.split(" "); 
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);
            String s1 = br.readLine();
            String []s2 = s1.split(" ");
            int[] a = new int[n];
            for( int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s2[i]);
            Solution ob = new Solution();
            int res  = ob.max_sum(a, k);
            System.out.println(res);
        }
	}
}
// } Driver Code Ends




class Solution
{
    static int find(int[] arr,int k,int n,int[][] dp,int pv,int sum){
        if(k==0) return sum;
        if(n<0||k<1) return -1;
        if(dp[n][k]!=-1) return dp[n][k];
        if(arr[n]<=pv){
            int tk=find(arr,k-1,n-1,dp,arr[n],sum+arr[n]);
            int nt=find(arr,k,n-1,dp,pv,sum);
            return Math.max(tk,nt);
        }
        return find(arr,k,n-1,dp,pv,sum);
    }
    public int max_sum(int[] a, int k)
    {
        // Code here
        int n=a.length;
        int[][] dp=new int[n][k+1];
        for(int[] t:dp) Arrays.fill(t,-1);
        int ans=find(a,k,n-1,dp,Integer.MAX_VALUE,0);
        return ans>0?ans:-1;
    }
}