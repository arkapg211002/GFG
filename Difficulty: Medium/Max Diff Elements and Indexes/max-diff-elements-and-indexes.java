//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int arr[] = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxValue(arr));
        }
        scanner.close();
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    public int maxValue(int arr[]) {
        // code here
        int n = arr.length;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        int res = 0;
        
        for(int i = 0; i<n; i++){
            max2 = Math.max(max2, arr[i] - i);
            min2 = Math.min(min2, arr[i] - i);
            
            max1 = Math.max(max1, arr[i] + i);
            min1 = Math.min(min1, arr[i] + i);
        }
        
        res = Math.max(res, max1-min1);
        res = Math.max(res, max2 - min2);
        
        return res;
        
    }
};