//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Integer values
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into Integer values and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            int ans = new Solution().lengthOfLongestAP(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    Integer arr[];
    int lengthOfLongestAP(Integer[] arr) {
        // code here
        this.arr=arr;
        int res=0;
        if(arr.length<=2) return arr.length;
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int diff=arr[j]-arr[i];
                res=Math.max(res,solve(j,j+1,diff));
            }
        }
        return 2+res;
    }
    
    int solve(int p,int ind,int diff){
        if(ind>=arr.length) return 0;
        
        if(arr[ind]-arr[p]==diff){
            return 1+solve(ind,ind+1,diff);
        }
        else{
            return solve(p,ind+1,diff);
        }
    }
}
