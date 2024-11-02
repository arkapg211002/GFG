//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
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
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends



// in any case, if we have sorted numbers and we have to make them equal, we should choose median
// now let's say the incrementing/decrementing each number is 1 step, we will always have numbers of steps
// as sum2-sum1, where
// for N is odd (x,y,z,i,j), assume it to be sorted, sum1 = x+y, sum2 = i+j
// for N is even (x,y,z,i), assume it to be sorted, sum1 = x+y, sum2 = z+i
class Solution {
    public long[] optimalArray(int n,int a[])
    {
        long prefixSum[] = new long[n];
        long result[] = new long[n];
        result[0] = 0;
        
        Arrays.fill(prefixSum, 0);
        
        prefixSum[0] = a[0];
        for(int i=1;i<n;i++)
            prefixSum[i] = prefixSum[i-1]+a[i];
            
        for(int i=1;i<n;i++){
            
            int totalElements = i+1;
            long diff = 0;
            
            int mid=i/2;
            if(totalElements % 2 == 0){
                long sum1=prefixSum[mid];
                long sum2=prefixSum[i]-prefixSum[mid];
                diff=sum2-sum1;
            }else{
                long sum1 = prefixSum[mid-1];
                long sum2 = prefixSum[i]- prefixSum[mid];
                diff=sum2-sum1;
            }
            
            result[i] = diff;
        }
        
        return result;
    }
}
        
