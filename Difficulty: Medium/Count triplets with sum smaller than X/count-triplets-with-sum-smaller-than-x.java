//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long ans = 0;
        for(int i=0;i<n-2;i++){
            if(i!=0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                if(arr[i] + arr[j] + arr[k] >= sum){
                    k--;
                }
                else{
                    ans = ans + (k-j);
                    j++;
                }
                while(j<k && arr[j] == arr[j+1]) j++;
                while(j<k && arr[k] == arr[k-1]) k--;
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            //            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int k = Integer.parseInt(q[1]);
            //            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            //            String line2 = br.readLine();
            //            String[] a2 = line2.trim().split("\\s+");
            //            long b[] = new long[m];
            //            for (int i = 0; i < m; i++) {
            //                b[i] = Long.parseLong(a2[i]);
            //            }
            Solution ob = new Solution();
            long ans = ob.countTriplets(n, k, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends