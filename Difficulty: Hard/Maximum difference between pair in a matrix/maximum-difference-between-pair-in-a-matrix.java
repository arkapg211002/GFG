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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] mat = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.findMaxValue(n, mat);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findMaxValue(int N, int[][] mat) {
        // code here
        
        int[] temp1 = new int[N];
        int[] temp2 = new int[N];
        temp1[N-1] = mat[N-1][N-1];
        
        for(int j=N-2; j>=0;j--){
            temp1[j] = Math.max(temp1[j+1], mat[N-1][j]);
        }
        
        int maxValue = Integer.MIN_VALUE;
        for(int i=N-2;i>=0;i--){
            temp2[N-1] = Math.max(temp1[N-1], mat[i][N-1]);
        
            for (int j =N-2; j>=0;j--) {
                maxValue = Math.max(maxValue, temp1[j+1] - mat[i][j]);
                temp2[j] = Math.max(mat[i][j], Math.max(temp1[j], temp2[j+1]));
            }
            temp1 = Arrays.copyOf(temp2, temp2.length);
        }
        
        return maxValue;
        
        
    }
}    
