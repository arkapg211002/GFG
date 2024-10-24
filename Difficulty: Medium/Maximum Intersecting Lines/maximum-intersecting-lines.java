//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int lines[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (i = 0; i < N; i++) {
                    lines[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxIntersections(lines, N));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxIntersections(int[][] lines, int N) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int max = 1;
        for(int i=0; i<N; i++) {
            int start = lines[i][0];
            int end = lines[i][1]+1;
            
            map.put(start, map.getOrDefault(start, 0)+1);
            map.put(end, map.getOrDefault(end, 0)-1);
        }
        
        int sum = 0;
        
        for(int el : map.keySet()) {
            sum += map.get(el);
            if(max < sum) {
                max = sum;
                
            }
        }
        
        return max;
    }
}
