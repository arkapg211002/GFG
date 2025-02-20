//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N-1];
            
            for(int i=0; i<N-1; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.socialNetwork(arr,N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Pair{
    int node;
    int dist;
    public Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}

 class AdjacencyListGraph<T> {
    private Map<T, Set<T>> adjacencyList;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }


    // Add an edge to the graph
    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);

        adjacencyList.get(source).add(destination);
        // for undirected graph
    }


    // Get all neighbors of a vertex
    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }





}


class Solution {
    static ArrayList<Pair> BFS(int startvertex, AdjacencyListGraph<Integer>graph){
        Set<Integer>visited=new HashSet<>();
        Queue<Pair>queue=new LinkedList<>();
        visited.add(startvertex);
        ArrayList<Pair>list=new ArrayList<>();
        list.add(new Pair(startvertex,0));
        queue.add(new Pair(startvertex,0));
        while (!queue.isEmpty()){
            Pair vertex=queue.poll();
            int node=vertex.node;
            int dist=vertex.dist;

            for (int neighbor:graph.getNeighbors(node)){
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    list.add(new Pair(neighbor,dist+1));
                    queue.add(new Pair(neighbor,dist+1));
                }
            }
        }
        list.sort(Comparator.comparingInt((Pair p) -> p.node)
                            .thenComparingInt(p -> p.dist));
        return list;
    }
    static String socialNetwork(int[] arr, int N) {
        AdjacencyListGraph<Integer>graph=new AdjacencyListGraph<>();
        int n=N;
        int j=0;
        for (int i = 2; i <=n; i++) {
            graph.addEdge(i,arr[j]);
            j++;
        }
        String rez="";
        for (int i = 2; i <=n; i++) {
           ArrayList<Pair>list=BFS(i,graph);
           for (Pair p:list){
               if(p.dist==0)continue;
               rez+=i+" "+p.node+" "+p.dist+" ";
           }
        }
        return rez;
    }
};
