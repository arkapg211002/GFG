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
            int n = Integer.parseInt(S[0]);
            int q = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int[] nums = new int[n];
            String[] S1 = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S1[i]);
            int[][] Queries = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] S3 = br.readLine().trim().split(" ");
                for(int j = 0; j < S3.length; j++){
                    Queries[i][j] = Integer.parseInt(S3[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.solveQueries(nums, Queries, k);
            for(int i = 0; i < ans.length; i++)
                System.out.println(ans[i]);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Query{
        int L;
        int R;
        int idx;
        public Query(int L,int R,int idx){
            this.L=L;
            this.R=R;
            this.idx=idx;
        }
    } 
    
    
    public int freq[]=new int[1001];
    
    public int[] solveQueries(int[] nums, int[][] Queries, int k)
    {
        
        ArrayList<Query>Qs=new ArrayList<>();
        
        int m=Queries.length;
        int block_size=(int)Math.sqrt(m)+1;
        
        int[]ans=new int[m];
        
        for(int i=0;i<m;i++){
            Qs.add(new Query(Queries[i][0],Queries[i][1],i));
        }
        
        Collections.sort(Qs,new Comparator<Query>(){
            public int compare(Query a,Query b){
                if(a.L/block_size==b.L/block_size)return a.R-b.R;
                return a.L-b.L;
            }
        });
        
        int currL=0; int currR=0;
        int currAns=0;
        
        for(Query q:Qs){
            
            int L=q.L-1;
            int R=q.R-1;
            int idx=q.idx;
            
            while(currL<L){
                freq[nums[currL]]--;
                if(freq[nums[currL]]==k-1)currAns--;
                currL++;
            }
            
            while(currL>L){
                freq[nums[currL-1]]++;
                if(freq[nums[currL-1]]==k)currAns++;
                currL--;
            }
            
            while(currR<=R){
                freq[nums[currR]]++;
                if(freq[nums[currR]]==k)currAns++;
                currR++;
            }
            
            while(currR>R+1){
                freq[nums[currR-1]]--;
                if(freq[nums[currR-1]]==k-1)currAns--;
                currR--;
            }
            ans[idx]=currAns;
        }
        
        return ans;
        
    }
}