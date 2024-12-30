//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    private int[] next_large(List<Integer> arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.size()];
        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr.get(i) >= arr.get(s.peek())) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = arr.size();
            } else {
                result[i] = s.peek();
            }

            s.push(i);
        }
        return result;
    }

    private int[] prev_large(List<Integer> arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            while (!s.isEmpty() && arr.get(i) > arr.get(s.peek())) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(i);
        }
        return result;
    }
    
    public int sumOfMax(List<Integer> arr) {
        int sum = 0;
        int next[] = next_large(arr);
        int prev[] = prev_large(arr);
        for (int i = 0; i < arr.size(); i++) {
            int left = i - prev[i];
            int right = next[i] - i;
            sum = sum + (left * right * arr.get(i));
        }
        return sum;
    }
}


//{ Driver Code Starts.

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            List<Integer> arr = new ArrayList<Integer>();

            for (int i = 0; i < str.length; i++) {
                arr.add(Integer.parseInt(str[i]));
            }
            int ans = new Solution().sumOfMax(arr);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends