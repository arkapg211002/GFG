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
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        
out.println("~");
}
        out.close();
    }
}

// } Driver Code Ends






class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        int count = 0;
        char[] arr = S.toCharArray();
        
        for(int i=1;i<N;i++){
            if(arr[i] == arr[i-1]){
                count++;
            }
        }
        
        if(count == 0){
            return 0;
        }
        
        for(int i=0;i<N;i++){
            int idx = P[i];
            if(idx != 0 && arr[idx] == arr[idx-1]){
                count--;
            }
            
            if(idx != N-1 && arr[idx] == arr[idx+1]){
                count--;
            }
            
            arr[idx] = '?';
            
            if(count == 0){
                return i+1;
            }
            
        }
        
        return -1;
    }
}
        