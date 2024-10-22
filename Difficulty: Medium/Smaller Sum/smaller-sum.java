//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    class Pair{
        int num;
        int ind;
        public Pair(int n,int i){
            this.num = n;
            this.ind = i;
        }
    }
    public long[] smallerSum(int n,int arr[])
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.num-b.num;
        });
        for(int i=0;i<n;i++){
            pq.offer(new Pair(arr[i],i));
        }
        long[] ans = new long[n];
        long sum = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int ind = p.ind;
            ans[ind]=sum;
            long temp = sum;
            while(pq.size()>0 && pq.peek().num==p.num){
                Pair pr = pq.poll();
                int i = pr.ind;
                ans[i]=temp;
                sum +=pr.num;
            }
            sum +=p.num;
        }
        return ans;
    }
}