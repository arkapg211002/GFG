//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.minSprinkler(N, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minSprinkler(int N, int[] arr) {
        // Create an array to store the range of coverage for each sprinkler
        int[][] ranges = new int[N][2];  // Correctly initializing a 2D array
        
        for (int i = 0; i < N; i++) {
            int left = Math.max(1, i + 1 - arr[i]);  // Convert to 1-based index
            int right = Math.min(N, i + 1 + arr[i]);
            ranges[i][0] = left;   // start of range
            ranges[i][1] = right;  // end of range
        }
        
        // Sort ranges by their starting position
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        
        int sprinklers = 0;
        int coveredTill = 0;
        int farthest = 0;
        int i = 0;
        
        // Greedily find the minimum number of sprinklers
        while (coveredTill < N) {
            boolean found = false;
            
            // Check if we can extend the coverage using the next available sprinklers
            while (i < N && ranges[i][0] <= coveredTill + 1) {
                farthest = Math.max(farthest, ranges[i][1]);
                i++;
                found = true;
            }
            
            if (!found) return -1;  // If no sprinkler can cover the gap
            
            sprinklers++;  // We found one sprinkler to extend the range
            coveredTill = farthest;  // Update the covered range
        }
        
        return sprinklers;
    }
}
        
