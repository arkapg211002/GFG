//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMissing(int[] arr) {
        // code here
        int length=arr.length;
        int common_difference=(arr[arr.length-1]-arr[0])/length;
        int i=0;
        int j=arr[i];
        while(i<arr.length){
            if(arr[i]!=j){
                break;
            }
            j+=common_difference;
            i++;
        }
        return j;
    }
}
