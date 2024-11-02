//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java
class Pair{
    int first;
    int second;
    int third;
    
    public Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution{
    public int[][] chefAndWells(int n,int m,char c[][]){
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='W'){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
        

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int d = q.peek().third;
            q.remove();
            
            if(c[row][col]=='H')
                dist[row][col] = 2*d;
            
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 &&  ncol<m && !vis[nrow][ncol]
                && (c[nrow][ncol]=='H'||c[nrow][ncol]=='.')){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol, d+1));
                    }
                }
            }
            for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && c[i][j]=='H')
                    dist[i][j] = -1;
            }
        }
        return dist;
    }
}