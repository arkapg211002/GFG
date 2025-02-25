//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int M; 
            M = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.maxHeight(N, A, M);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean cutWood(int N,int[] A,int M, int mid){
        long sum=0;
        for(int i=0;i<N;i++){
            if(A[i]>mid) sum+=A[i]-mid;
        }
        return (sum>=M);
    }
    public static int maxHeight(int N, int[] A, int M) {
        // code here
        Arrays.sort(A);
        int low=A[0],high=A[N-1];
        while(low<=high){
            int mid=low+((high-low)/2);
            //System.out.println("mid :"+mid);
            if(cutWood(N,A,M,mid)){
                low=mid+1;
                //System.out.println("low :"+low);
            }else{
                high=mid-1;
                //System.out.println("high :"+high);
            }
        }
        return high;
    }
}
        
