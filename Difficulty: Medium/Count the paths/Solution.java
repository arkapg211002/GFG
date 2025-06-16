class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
   
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=V;i++) graph.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        int vis[]=new int[V+1];
        Arrays.fill(vis,-1);
       return recurse(src,vis,dest,graph);
    }
      int recurse(int i,int vis[],int dest,ArrayList<ArrayList<Integer>> graph){
        
        if(i==dest) return vis[i]=1;
        if(vis[i]>=0) {
            return vis[i];
        }
        vis[i]=0;
        for(int k:graph.get(i)){
           vis[i]+= recurse(k,vis,dest,graph);
        }
        return vis[i];
    }
}

