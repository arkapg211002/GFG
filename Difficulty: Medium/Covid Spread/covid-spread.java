//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution{
     public int helpaterp(int[][] arr) {
        // code here
        int n=arr.length,m=arr[0].length;
        boolean[][] vis=new boolean[n][m];
        int srr[][]=new int[n][m];
        
        class node{
            int i;int j;int t;
            node(int i,int j,int t){
                this.i=i;
                this.j=j;
                this.t=t;
            }
        }
        
        Queue<node> q=new LinkedList();
        int infcnt=0,ones=0,res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==2){
                q.offer(new node(i,j,0));
                vis[i][j]=true;
                }
                
                if(arr[i][j]==1)ones++;
            }
        }
        
        
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        
        while(!q.isEmpty()){
            node nq=q.poll();
            int rval=nq.i,cval=nq.j;
            res=Math.max(res,nq.t);
            for(int i=0;i<4;i++){
                int rc=rval+dr[i];
                int cv=cval+dc[i];
                if(rc<0||cv<0||rc>=n||cv>=m)continue;
                
                if(!vis[rc][cv]&&arr[rc][cv]==1){
                    vis[rc][cv]=true;
                    arr[rc][cv]=2;
                    q.offer(new node(rc,cv,nq.t+1));
                    infcnt++;
                }
            }
        }
        
        if(ones==infcnt)return res;
        
        return -1;
    }
}
