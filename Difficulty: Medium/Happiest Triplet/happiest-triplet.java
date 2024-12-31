//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int[] smallestDifferenceTriplet(int arr1[], int arr2[], int arr3[]) {
        // Sort all arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        
        // Pointers for each array
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[3];
        
        // Traverse all arrays and find the smallest difference
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // Get the maximum and minimum of the current triplet
            int a = arr1[i], b = arr2[j], c = arr3[k];
            int currentMax = Math.max(a, Math.max(b, c));
            int currentMin = Math.min(a, Math.min(b, c));
            
            // Calculate the difference
            int currentDiff = currentMax - currentMin;
            
            // If we found a smaller difference, update the result
            if (currentDiff < minDiff || 
                (currentDiff == minDiff && (a + b + c) < (result[0] + result[1] + result[2]))) {
                minDiff = currentDiff;
                result[0] = a;
                result[1] = b;
                result[2] = c;
            }
            
            // Move the pointer of the array that has the smallest element
            if (currentMin == a) {
                i++;
            } else if (currentMin == b) {
                j++;
            } else {
                k++;
            }
        }
        
        // Sort the result in descending order
        Arrays.sort(result);
        return new int[]{result[2], result[1], result[0]};  // Return in descending order
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] arr1Str = line.split(" ");
            int[] arr1 = new int[arr1Str.length];
            for (int i = 0; i < arr1Str.length; i++) {
                arr1[i] = Integer.parseInt(arr1Str[i]);
            }

            line = sc.nextLine();
            String[] arr2Str = line.split(" ");
            int[] arr2 = new int[arr2Str.length];
            for (int i = 0; i < arr2Str.length; i++) {
                arr2[i] = Integer.parseInt(arr2Str[i]);
            }
            line = sc.nextLine();
            String[] arr3Str = line.split(" ");
            int[] arr3 = new int[arr3Str.length];
            for (int i = 0; i < arr3Str.length; i++) {
                arr3[i] = Integer.parseInt(arr3Str[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.smallestDifferenceTriplet(arr1, arr2, arr3);
            System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends