//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends




//User function Template for Java
class Pair{
    int x;
    int y;
    int steps;
    
    public Pair(int x , int y , int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
class Solution{
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        // Code Here.
        int m = arr.length;
        int n = arr[0].length;
        List<Integer> lst = new ArrayList<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        boolean[][]visited = new boolean[m][n];
        
        q.add(new Pair(start_x, start_y ,  0));
        
        visited[start_x][start_y] = true;
        
        
        int knight_x[]={1,2,2,1,-1,-2,-2,-1};
        int knight_y[]={-2,-1,1,2,2,1,-1,-2};
        
        while(!q.isEmpty()){
           int size = q.size();
           
             int sum=0;
             
            for(int i=0;i<size;i++){
                
                Pair curr=q.poll();
                
                 sum += arr[curr.x][curr.y];
                 
                visited[curr.x][curr.y]=true;
                
                for(int j=0;j<8;j++){
                    int newX = curr.x+knight_x[j];
                    int newY = curr.y+knight_y[j];
                    if(newX >= 0 && newX < arr.length && newY>=0 && newY<arr[0].length && visited[newX][newY]==false){
                        q.add(new Pair(newX,newY,curr.steps+1));
                        visited[newX][newY]=true;
                    }
                }
                
            }
            lst.add(sum);
        }
        
        int step[] = new int[lst.size()];
        int index=0;
        for(int x:lst){
            step[index++]=x;
        }
        int temp[]=new int[step.length];
        for(int i=0;i<temp.length;i++){
            int j=i;
            while(j<temp.length){
                temp[i]=temp[i]+step[j];
                int aux=j;
                j=j+step[j];
                if(aux==j){
                    break;
                }
            }
        }
        int ansIdx=0,max=0;
        for(int i=0;i<temp.length;i++){
            if(max<temp[i]){
                max=temp[i];
                ansIdx=i;
            }
            
        }
        return ansIdx;
        
    }
}   