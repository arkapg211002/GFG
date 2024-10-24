//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isStraightHand(int n, int groupSize,int hand[]) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            int firstNumber = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(firstNumber + i)) {
                    return false;
                }

                map.put(firstNumber + i, map.get(firstNumber + i) - 1);
                if (map.get(firstNumber + i) == 0) {
                    map.remove(firstNumber + i);
                }
            }
        }

        return true;
    }
}
