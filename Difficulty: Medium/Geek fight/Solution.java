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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] power = IntArray.input(br, n);
            
            
            int q; 
            q = Integer.parseInt(br.readLine());
            
            
            int[] Q = IntArray.input(br, q);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.win(n, power, q, Q);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> win(int n, int[] power, int q, int[] Q) {
        Arrays.sort(power);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < q; i++) {
            int count = 0;
            long sum = 0;
            int j = 0;
            
            while (j < n && power[j] <= Q[i]) {
                count++;
                sum += power[j];
                j++;
            }
            
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(count);
            pair.add((int) sum);
            result.add(pair);
        }
        
        return result;
    }
}  
        
