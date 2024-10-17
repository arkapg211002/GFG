//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] intervals = IntMatrix.input(br, n, 2);
            
            Solution obj = new Solution();
            int res = obj.overlap(n, intervals);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int overlap(int n, int[][] intervals) {
       
          //calculate maximum overlapping interval

        //sweep liner algorithm is used


        //find range

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
       
        for(int i = 0; i < n; i++){
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }

        int eventCount[] = new int[max + 2];


        //find the count 

        for(int i = 0; i < n; i++){
            eventCount[intervals[i][0]]++;
            eventCount[intervals[i][1]+1]--;
        }


           //max sum


           int maxOverlaps = 0;
           int sum = 0;

           for(int i = min; i < max+2; i++){
            sum += eventCount[i];
            maxOverlaps = Math.max(maxOverlaps, sum);


           }


        return maxOverlaps;
        
        
    }
}
        
        
