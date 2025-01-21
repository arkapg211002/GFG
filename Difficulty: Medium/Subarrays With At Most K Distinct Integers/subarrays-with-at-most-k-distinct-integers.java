//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character

        while (t-- > 0) {
            String[] arrInput = sc.nextLine().split(" ");
            int[] arr = new int[arrInput.length];
            for (int i = 0; i < arrInput.length; i++) {
                arr[i] = Integer.parseInt(arrInput[i]);
            }

            int k = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            System.out.println(obj.atMostK(arr, k));
        }

        sc.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {

    // Function to count subarrays having at most k distinct elements
    static int atMostK(int[] arr, int k) {
        int n = arr.length;
        int res = 0;

        // pointers to mark the left and right boundary
        int left = 0, right = 0;

        // Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        while (right < n) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            // If this is a new element in the window, 
            // decrement k by 1
            if (freq.get(arr[right]) == 1)
                k -= 1;

            // Shrink the window until distinct element
            // count becomes <= k
            while (k < 0) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0)
                    k += 1;
                left += 1;
            }

            // add all possible subarrays to result
            res += (right - left + 1);
            right += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 3, 4, 2, 1};
        int k = 2;
        System.out.println(atMostK(arr, k));
    }
}