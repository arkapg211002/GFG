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
            
            int[] a = IntArray.input(br, 2);
            int n = a[0],k=a[1];
            
            int[][] mat = IntMatrix.input(br, a[0], a[0]);
            
            Solution obj = new Solution();
            int res = obj.selectKcities(n,k, mat);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int selectKcities(int n,int k, int[][] mat) {
        
        int ans=Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            ans=Math.min(ans, helper(n, k, mat, i));
//store the minimum maximum distance found so far, considering that city as an ATM server
        }
        
        return ans;
    }
    
    private static int helper(int n, int k, int [][]mat, int max){
        
        int [] dist= new int [n];
//store the minimum distances from the current city max to all other cities.
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        ArrayList<Integer> atms= new ArrayList<>();
//created to keep track of the selected ATM servers. 

        while(k-->0){
            atms.add(max);

            for(int i=0; i<n; i++){
                dist[i]=Math.min(dist[i], mat[max][i]);     
            }
            
            max=maxValueIndex(dist,n);      
//to find the index of the city with the maximum distance in the dist array.
//This city will be chosen as the next ATM server in the next iteration. 
        }
        
        return dist[max];
//returns the maximum distance of the last selected ATM server, which is stored in dist[max].
    }
    
    static int maxValueIndex(int[] dist, int n) {
        
            int j = 0;
            
            for(int i = 0; i < n; i++) {
                if (dist[i] > dist[j])
                    j = i;
            }
            return j;
        }
    }
        
