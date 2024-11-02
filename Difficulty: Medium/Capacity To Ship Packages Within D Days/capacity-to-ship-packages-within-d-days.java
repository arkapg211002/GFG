//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends



class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        int minCap=0;
        int maxCap=0;
        for(int i=0;i<n;i++)
        {
            minCap=Math.max(minCap,arr[i]);
            maxCap+=arr[i];
        }
        while(minCap<=maxCap)
        {
            int mid=minCap+(maxCap-minCap)/2;
            int days=1;
            int sum=0;
            for(int i=0;i<arr.length;i++)
            {
                if(sum+arr[i]>mid)
                {
                    days++;
                    sum=0;
                }
                sum+=arr[i];
            }
            if(days>d)
            {
                minCap=mid+1;
            }else{
                maxCap=mid-1;
            }
        }
        return minCap;
    }
};