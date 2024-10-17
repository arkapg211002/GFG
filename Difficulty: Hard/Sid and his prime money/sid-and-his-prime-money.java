//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

import java.util.*;

class Solution {
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> primeMoney(int arr[]) {
        int n = arr.length;
        if (n == 0) return Arrays.asList(0, 0); 
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        int max1 = 1;    
        int max2;       
        int amount2 = 0; 
    
        for (int i = 0; i < n - 1; i++) {
            max2 = 1;
            if (arr[i] < arr[i + 1]) {
                d.add(i); 
                while (i < n - 1 && arr[i] < arr[i + 1]) {
                    max2++;
                    i++;
                }

                c.add(max2);
                d.add(i);  

                if (max1 < max2) {
                    max1 = max2;
                }
            }
        }

        
        if (c.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (isPrime(arr[i])) {
                    amount2 =
                        Math.max(amount2, arr[i]); 
                }
            }
        }
       
        else {
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i) == max1) {
                    int amount1 = 0;
                    for (int m = d.get(2 * i); m <= d.get(2 * i + 1); m++) {
                        if (isPrime(arr[m])) {
                            amount1 +=
                                arr[m]; 
                        }
                    }
                    amount2 =
                        Math.max(amount2, amount1); 
                }
            }
        }

        return Arrays.asList(max1, amount2);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();
            List<Integer> ans = obj.primeMoney(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}
// } Driver Code Ends