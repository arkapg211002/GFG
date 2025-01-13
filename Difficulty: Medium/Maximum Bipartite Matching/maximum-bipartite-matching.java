//{ Driver Code Starts
//Initial Template for Java

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
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] graph)
    {
        // Code here
        int maximumMatching =0;
        int numberOfPerson = graph.length;
        int numberOfJobs = graph[0].length;
        int jobAssigments[] = new int [numberOfJobs];
        Arrays.fill(jobAssigments,-1);

        for(int i=0;i<numberOfPerson;i++){
            //System.out.println();
            
                if(assignJob(graph,i,jobAssigments,numberOfPerson,numberOfJobs,new boolean[numberOfPerson])){
                    maximumMatching++;
                   
                }
            
        }
        return maximumMatching;
    }
    private boolean assignJob(int[][] graph,int person, int[] jobAssigments,int numberOfPerson,int numberOfJobs,boolean visited[]){
        //System.out.println(person);
        if(visited[person]) return false;
        visited[person] = true;
        for(int j=0;j<numberOfJobs;j++){
            if(graph[person][j]==1){
                if(jobAssigments[j]==-1) {
                    jobAssigments[j] = person;
                    return true;
                }
            }
        }

        for(int j=0;j<numberOfJobs;j++){
            if(graph[person][j]==1){
                if(assignJob(graph,jobAssigments[j],jobAssigments,numberOfPerson,numberOfJobs,visited)){
                    jobAssigments[j] = person;
                    return true;
                }
            }
        }

        return false;
    }
}