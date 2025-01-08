//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int s =0 , e = arr.length-1, cnt = 0;
        while(s < e){
            if(arr[s] + arr[e] == target){
                cnt++;
                int temp = e-1;
                while( (s < temp) && (arr[temp] == arr[e])){
                    cnt++; temp--;
                }
                 s++;
            }
            else if(arr[s] + arr[e] > target){
                e--;
            }
            else {
                s++;
            }
        }
        return cnt;
    }
}

//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends