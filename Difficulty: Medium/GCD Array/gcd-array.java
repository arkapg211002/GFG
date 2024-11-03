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
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, K, arr);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution {
    public static int solve(int N, int K, int[] arr) {
        // code here
        if(N==1){
            return arr[0];
        }
        int ans=1;
        for(int i=1;i<N;i++){
            arr[i]+=arr[i-1];
        }
        if(K==1){
            return arr[N-1];
        }
        for(int i=2;i*i<=arr[N-1];i++){
            if(arr[N-1]%i==0){
                int c=0,d=0,z=arr[N-1]/i;
                for(int j:arr){
                    if(j%i==0){
                        c++;
                    }
                    if(j%z==0){
                        d++;
                    }
                }
                if(c>=K){
                    ans=Math.max(ans,i);
                }
                if(d>=K){
                    ans=Math.max(ans,z);
                }
            }
        }
        return ans;
    }
}
        