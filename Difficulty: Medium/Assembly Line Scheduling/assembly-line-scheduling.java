//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}


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
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] a = IntMatrix.input(br, 2, n);
            
            
            int[][] T = IntMatrix.input(br, 2, n);
            
            
            int[] e = IntArray.input(br, 2);
            
            
            int[] x = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            int res = obj.carAssembly(n, a, T, e, x);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int carAssembly(int n, int[][] a, int[][] T, int[] e, int[] x) {
        // code here
         a[0][0]+=e[0];
         a[1][0]+=e[1];
         
         a[0][a[0].length-1]+=x[0];
         a[1][a[0].length-1]+=x[1];
         
        //  System.out.println(a[0][0]+" : "+a[1][0]);
         for(int i=1;i<a[0].length;i++){
             
             int a1 = Math.min(a[0][i-1]+a[0][i], a[1][i-1]+a[0][i]+T[1][i]);
             
             
             int a2 = Math.min(a[1][i-1]+a[1][i], a[0][i-1]+a[1][i]+T[0][i]);
             
             a[0][i] = a1;
             a[1][i] = a2;
            //  System.out.println(a1+" : "+a2);
         }
         
         return Math.min(a[0][a[0].length-1], a[1][a[0].length-1]);
    }
}
        