//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length];

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSurpasser(arr);

            // Print the result list
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static int merge(int[] arr, int lo, int mid, int hi, 
                            Map<Integer, Integer> m) {

        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data into temporary array left and right
      for (int i = 0; i < n1; i++)
            left[i] = arr[lo + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = lo;

        // Merging two halves
        while (i < n1 && j < n2) {

            // All elements in right[j..n2] are greater than left[i]
            // So add n2 - j, in surpasser count of left[i]
            if (left[i] < right[j]) {
                m.put(left[i], m.getOrDefault(left[i], 0) + n2 - j);
                arr[k++] = left[i++];
            } 
            else {
                arr[k++] = right[j++];
            }
        }
      // Copy remaining elements of left[] if any
        while (i < n1)
            arr[k++] = left[i++];

        // Copy remaining elements of right[] if any
        while (j < n2)
            arr[k++] = right[j++];

        return 0;
    }
    
    static void mergeSort(int[] arr, int lo, int hi, 
                                 Map<Integer, Integer> m) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // Sort left and right half
            mergeSort(arr, lo, mid, m); 
            mergeSort(arr, mid + 1, hi, m);

            // Merge them
            merge(arr, lo, mid, hi, m);
        }
    }
    // Method to find surpasser count
    public List<Integer> findSurpasser(int[] arr) {
        // code here
        
        
        // approch 1 time O(n^2)
        
    //     int n = arr.length;
    //     // store output
    //     List<Integer> res = new ArrayList<>();
        
    //     for(int i=0; i<arr.length; i++){
    //         int count = 0;
    //         for(int j=i+1; j<arr.length; j++){
    //             if(arr[i] < arr[j]){
    //                 count++;
    //             }
    //         }
    //         res.add(count);
    //     }
    //     return res;
    // }
    
    
    
    // approch 2 O(nlogn)
    
        int n = arr.length;

        // Map to store surpasser counts
        Map<Integer, Integer> m = new HashMap<>();
        // Duplicate array to perform merge Sort
        // so that original array is not modified
        int[] dup = arr.clone();

        mergeSort(dup, 0, n - 1, m);

        // Store surpasser counts in result array
        // in the same order as given array
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(m.getOrDefault(arr[i], 0));

        return res;
    }
    
    
}


