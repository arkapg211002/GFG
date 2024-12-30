//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            Long[] res = ob.distributeCandies(N,K);
            
            for(int i=0; i<K; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution {
    static Long[] distributeCandies(int N, int K) {
        Long[] arr = new Long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = 0L;
        }

        int person = 0; 
        int candies = 1; 

        while (N > 0) {
            if (candies > N) { 
                arr[person] += N;
                break;
            } 
                arr[person] += candies;
                N -= candies;
                candies++;
                person = (person + 1) % K; 
        }

        return arr;
    }
}