//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s1 = br.readLine().trim();
            String []S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            long C = Long.parseLong(S1[1]);
            String s2 = br.readLine().trim();
            String []S2 = s2.split(" ");
            long [] w = new long[n];
            long [] p = new long[n];
            for(int i = 0; i < n; i++){
                w[i] = Long.parseLong(S2[2*i]);
                p[i] = Long.parseLong(S2[(2*i)+1]);
            }
            Solution ob = new Solution();
            double ans = ob.maximumProfit(n, C, w, p);
            String a1 = String.format("%.3f",ans);
            System.out.println(a1);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java
class Solution
{
    public double maximumProfit(int N, long C, long w[], long p[])
    {
        long[][] arr=new long[N][2];
        for(int i=0;i<N;i++){
            arr[i][0]=w[i];
            arr[i][1]=p[i];
        }
        Arrays.sort(arr, (a, b) -> {
            double ratioA = (double) a[1] / a[0];
            double ratioB = (double) b[1] / b[0];
            return Double.compare(ratioB, ratioA); 
        });
        double res=0;
        for(int i=0;i<N;i++){
            if(!ps(arr[i][0])){
                if(arr[i][0]<=C){
                    res+=arr[i][1];
                    C-=arr[i][0];
                }else{
                    double rem=((double)C*arr[i][1])/arr[i][0];
                    res+=rem;
                    break;
                }
            }
        }
        return res;
    }
    public static boolean ps(long num) {
        if (num < 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(num);
        return (long)sqrt * sqrt == num;
}
 
}