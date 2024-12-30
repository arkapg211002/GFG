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
            
            
            int[][] edges = IntMatrix.input(br, a[1], 2);
            
            Solution obj = new Solution();
            int [] res = obj.minimumTime(a[0],a[1], edges);
            for(int x: res)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int [] minimumTime(int n,int m, int[][] edges) {
        // code here
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
         for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        int indegree[]=new int[n];
        int job[]=new int[n];
        
        for(int i=0;i<m;i++){
            int u =edges[i][0]-1;
            int v = edges[i][1]-1;
            
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                job[i]=1;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nm : graph.get(curr)){
                indegree[nm]--;
                if(indegree[nm]==0){
                    q.add(nm);
                    job[nm] = job[curr]+1;
                }
            }
        }
        return job;
    }
}
        
        
