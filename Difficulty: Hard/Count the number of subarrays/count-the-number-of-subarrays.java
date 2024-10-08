//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            long L = Long.parseLong(input_line[1]); 
            long R = Long.parseLong(input_line[2]); 
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, L, R); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long count(int n,int arr[],long k ){
        long ans=0;
        long sum=0;
        for(int l=0, r=0; r<n;r++){
            sum+=arr[r];
            while(sum>k){
                sum-=arr[l];
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
    long countSubarray(int N,int A[],long L,long R) {
        // code here
        long ans1=count(N,A,R);
        long ans2=count(N,A,L-1);
        return ans1-ans2;
    }
} 