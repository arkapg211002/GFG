//{ Driver Code Starts
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

            int N = Integer.parseInt(br.readLine().trim());

            int arr[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBalloons(N, arr));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int mostBalloons(int N, int arr[][]) {
        int res = 0;
        Map<Double, Integer> slopeMap;
        int count = 0;
        
        for(int i=0;i<N;i++){
            slopeMap = new HashMap<>();
            count = 0;
            for(int j=0;j<N;j++){
                double slope;
                
                
                if(arr[j][0] == arr[i][0] && arr[j][1] == arr[i][1]){
                    count++;
                }
                else{
                    double denom = (arr[j][0]-arr[i][0]);
                    double numer = (arr[j][1]-arr[i][1]);
                    slope = (double)(numer /denom);
                    
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0)+1);
                    
                }
                
            }
            for(Map.Entry<Double, Integer> ent: slopeMap.entrySet()){
                if(res < ent.getValue()+count)
                    res = ent.getValue()+count;
            }
        }
        
        return res;
    }
}