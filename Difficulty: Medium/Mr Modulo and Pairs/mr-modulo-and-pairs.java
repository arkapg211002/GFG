//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends



class Solution {

    public List<Integer> findDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // if n/i is equal to i, add only i
                if (n / i == i) {
                    divisors.add(i);
                } else {
                    divisors.add(i);
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }

    public int printPairs(List<Integer> arr, int k) {
        int ans = 0;
        HashMap<Integer, Boolean> occ = new HashMap<>();

        for (int num : arr) {
            occ.put(num, true);
        }

        boolean isPairFound = false;

        for (int num : arr) {
            if (occ.containsKey(k) && k < num) {
                ans++;
                isPairFound = true;
            }

            if (num >= k) {
                List<Integer> divisors = findDivisors(num - k);
                for (int divisor : divisors) {
              
                    if (num % divisor == k && num != divisor &&
                        occ.containsKey(divisor)) {
                        ans++;
                        isPairFound = true;
                    }
                }
            }
        }
        return ans;
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            List<Integer> arr = new ArrayList<>();
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");

            for (String str : inputArray) {
                arr.add(Integer.parseInt(str));
            }

            int k = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            Solution solution = new Solution();
            System.out.println(solution.printPairs(arr, k));
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends