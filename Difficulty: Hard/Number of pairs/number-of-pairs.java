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
            
            
            int[][] pairs = IntMatrix.input(br, a[1], 2);
            
            Solution obj = new Solution();
            long res = obj.numberOfPairs(a[0], a[1], pairs);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class DisjointSet{
    public static int findParent(int v,int [] parent){
        if(parent[v]==v){
            return v;
        }
        return parent[v]= findParent(parent[v],parent);
    }
    public static void union(int u,int v,int [] size,int [] parent){
        //find parent of u and v
        int pu = findParent(u,parent);
        int pv = findParent(v,parent);
        if(size[pu]>size[pv]){
            parent[pv]= pu;
            size[pu]+=size[pv];
        }
        else{
            parent[pu]= pv;
            size[pv]+=size[pu];
        }
    }
}
class Solution {
    public static long numberOfPairs(int N, int P, int[][] pairs) {
        //we use disjoint set to find the number of connected compenents
        DisjointSet ds = new DisjointSet();
        //we use two array i.e. parrent array to store the parent vertices and rank array
        int [] parent = new int[N];
        int [] size = new int[N];
        //initially parent of vertices are parent itself and rank of all vertices are 0
        for(int i =0;i<N;i++){
            parent[i]= i;
            size[i]=1;
        }
        //we create a dynamic graph using disjoint set
        for(int i =0;i<P;i++){
            int u = pairs[i][0];
            int v = pairs[i][1];
            //find the parent of both vertices
            int pu = ds.findParent(u,parent);
            int pv = ds.findParent(v,parent);
            if(pu!=pv){
                // if both parents are not same then union the vertices
                ds.union(pu,pv,size,parent);
            }
        }
        long ans =0;
        int comp =0;
        for(int i =0;i<N;i++){
            //find the number of connected components
            if(parent[i]==i){
                //size of connected components
                int s = size[i];
                ans = ans+(comp*s);
                comp+= s;
            }
        }
        return ans;
    }
}
        
