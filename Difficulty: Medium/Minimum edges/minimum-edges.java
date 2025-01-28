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
            
            int[] a = new int[2];
            String s[] = br.readLine().trim().split(" ");
            if(s.length == 2){
                a[0] = Integer.parseInt(s[0]);
                a[1] = Integer.parseInt(s[1]);
            } else{
                a[0] = Integer.parseInt(s[0]);
                s = br.readLine().trim().split(" ");
                a[1] = Integer.parseInt(s[0]);
            }
            int[][] edges = IntMatrix.input(br, a[1], 2);
            
            
            int src; 
            src = Integer.parseInt(br.readLine());
            
            
            int dst; 
            dst = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.minimumEdgeReversal(edges, a[0], a[1], src, dst);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
       ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
       // System.out.println("1");
        for (int i=0; i<n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            graph.get(u).add(new int[]{v,0});
            graph.get(v).add(new int[]{u,1});
        }


        boolean[] visited = new boolean[n];

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{src-1, 0});

        while (queue.size() > 0) {

            int[] temp = queue.poll();

            int node = temp[0];
            int weights = temp[1];
            

            if (!visited[node]) {
                visited[node] = true;
                distance[node] = weights;
            } else if (weights < distance[node]) {
                distance[node] = Math.min(distance[node], weights);
            }

            for (int[] neighbours : graph.get(node)) {
                int vertex = neighbours[0];
                int weight = neighbours[1];


                if (!visited[vertex] || weight + weights < distance[vertex]) {
                    queue.add(new int[]{vertex, weight + weights});
                }
            }
        }
        return distance[dst-1] == Integer.MAX_VALUE ? -1 : distance[dst-1];
    }
}
        
        
