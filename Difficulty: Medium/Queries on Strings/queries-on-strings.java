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
            String str = br.readLine().trim();
            int q = Integer.parseInt(br.readLine().trim());
            int[][] Query = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    Query[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.SolveQueris(str, Query);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
     public int[] SolveQueris(String str, int[][] Query)

    {

        // Code here

        int[] ans=new int[Query.length];

        for(int i=0; i<Query.length; i++)

        {

            ans[i]=find(ans,str,Query[i]);

        }

        return ans;

    }

    public static int find(int[] ans, String str, int[] arr)

    {

        int a=arr[0];

        int b=arr[1];

        String ff=str.substring(a-1,b);

        int[] alfa=new int[26];

        int count=0;

        for(int i=0; i<ff.length(); i++)

        {

            if(alfa[ff.charAt(i)-97]==0)

                count++;

            alfa[ff.charAt(i)-97]+=1;

        }

 

        return count;
    }
}