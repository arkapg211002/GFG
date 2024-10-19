//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Qentry{
    int v;
    int dist;
}

class Solution{
    static int minThrow(int n, int arr[]){
        int moves[] = new int[31];
        
        Arrays.fill(moves,-1);
        for(int i=0;i<n;i++){
            moves[arr[2*i]] = arr[(2*i)+1];
        }
        Queue<Qentry> q = new LinkedList<>();
        boolean visited[] = new boolean[31];
        Qentry qe = new Qentry();
        qe.v = 1;
        qe.dist = 0;
        visited[1] = true;
        q.add(qe);
        while(!q.isEmpty()){
            qe = q.poll();
            int v = qe.v;
            if(v == 30){
                break;
            }
            for(int i=v+1;i<=v+6 && i<=30;i++){
                if(!visited[i]){
                    visited[i] = true;
                    Qentry val = new Qentry();
                    val.dist = qe.dist + 1;
                    if(moves[i]!=-1){
                        val.v = moves[i];
                    }else{
                        val.v = i;
                    }
                    q.add(val);
                }
            }
                
            
        }
        return qe.dist;
    }
}

