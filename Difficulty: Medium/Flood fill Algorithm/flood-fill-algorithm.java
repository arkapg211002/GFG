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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public static void helper(int image[][],int sr,int sc,int color,boolean isVisit[][],int orgCol){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length || isVisit[sr][sc] || image[sr][sc]!=orgCol){
            return;
        }
        isVisit[sr][sc]=true;
        image[sr][sc]=color;

        //left
        helper(image,sr,sc-1,color,isVisit,orgCol);
        //right
        helper(image,sr,sc+1,color,isVisit,orgCol);
        //up
        helper(image,sr-1,sc,color,isVisit,orgCol);
//down
        helper(image,sr+1,sc,color,isVisit,orgCol);

 


    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        boolean isVisit[][]=new boolean[image.length][image[0].length];
        int orgCol = image[sr][sc];
        if (orgCol != newColor) {
            helper(image, sr, sc, newColor, isVisit, orgCol);
        }
        return image;
        // Code here 
    }
}