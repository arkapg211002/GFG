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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    class Pair{
        int first,second;
       public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        //int dist[][]=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    break; // Found the source, no need to continue the loop
                }
            }
        }
        //q.add(new Pair(first,second));
        int  delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        while(!q.isEmpty()){
            Pair node=q.remove();
            int row=node.first;
            int col=node.second;
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]!=0 ){
                    if(grid[nrow][ncol]==2)return true;
                    grid[nrow][ncol]=0;
                    q.add(new Pair(nrow,ncol));
                }    
            }
        }
        return false;
        
        
    }
}

