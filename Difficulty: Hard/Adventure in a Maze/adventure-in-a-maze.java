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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int[] ans = obj.FindWays(matrix);
            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] FindWays(int[][] matrix)
    {
        // Code here
        //int[] result = new int[2];
        int n = matrix.length;
       List<List<List<Integer>>> dp = new ArrayList<>();
       for(int i=0;i<n;i++){
           List<List<Integer>> list = new ArrayList<>();
           for(int j=0;j<n;j++){
               list.add(new ArrayList<>());
           }
           dp.add(list);
       }
       
       for(int i = n-1;i>=0;i--){
           for(int j=n-1;j>=0;j--){
               List<Integer> list = new ArrayList<>();
               list.add(0);
               list.add(0);
               if(i== n-1 && j == n-1){
                   list.add(0,1);
                   list.add(1,matrix[i][j]);
               }else{
                   switch(matrix[i][j]){
                       case 1:
                           if(j!=n-1 && dp.get(i).get(j+1).get(0)>0){
                               list.add(0,dp.get(i).get(j+1).get(0));
                               list.add(1,dp.get(i).get(j+1).get(1) + 1);
                           }
                           break;
                        case 2:
                            if(i!=n-1 && dp.get(i+1).get(j).get(0)>0){
                               list.add(0,dp.get(i+1).get(j).get(0));
                               list.add(1,dp.get(i+1).get(j).get(1) + 2);
                           }
                            break;
                        case 3:
                            long sum =0;
                            int max = 0;
                            if(j!=n-1 && dp.get(i).get(j+1).get(0) >0){ 
                                sum += dp.get(i).get(j+1).get(0);
                                max = dp.get(i).get(j+1).get(1) + 3;
                            }
                            if(i!=n-1 && dp.get(i+1).get(j).get(0)>0){
                              sum += (long)dp.get(i+1).get(j).get(0);
                              sum%=1000000007;
                              max = Math.max(max,dp.get(i+1).get(j).get(1) + 3);
                            } 
                            
                            list.add(0,(int)sum);
                            list.add(1,max);
                            break;
                            
                   }
               }
               dp.get(i).get(j).add(list.get(0));
               dp.get(i).get(j).add(list.get(1));
           }
       }
       
       int[] result = new int[2];
       result[0] = dp.get(0).get(0).get(0);
       result[1] = dp.get(0).get(0).get(1);
       
       return result;
       
    }
}