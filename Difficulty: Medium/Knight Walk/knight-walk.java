//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int minStepToReachTarget(int K[], int T[], int N)
    {
    Queue<pair> q=new LinkedList<>();
    q.add(new pair(K[0],K[1],0));
    boolean vis[][]=new boolean[N+1][N+1];
   while(!q.isEmpty()){
       pair k=q.poll();
       int x=k.x;int y=k.y;int z=k.z;
       if(x<1||x>N||y<1||y>N){
           continue;
       }
       if(vis[x][y])continue;
       vis[x][y]=true;
       if(x==T[0]&&y==T[1])return z;
      q.add(new pair(x-1,y+2,z+1));
      q.add(new pair(x-2,y+1,z+1));
         q.add(new pair(x+1,y+2,z+1));
          q.add(new pair(x+2,y+1,z+1)); 
         q.add(new pair(x-2,y-1,z+1));
         q.add(new pair(x-1,y-2,z+1));
         q.add(new pair(x+2,y-1,z+1));
         q.add(new pair(x+1,y-2,z+1));
   }
       
       return -1; 
    }
    class pair {
        int x;int y;int z;
        pair(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }  
    

}

