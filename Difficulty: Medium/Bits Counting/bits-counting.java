//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.countBits(n);

            IntArray.print(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> countBits(int n) {

        ArrayList<Integer> res = new ArrayList();
        
        res.add(0);
        
        if(n == 0) return res;
        
        for(int i=1; i<=n; i++){
            
           res.add((i&1) + res.get(i>>1));
        }
        
        return res;
    }
}
