//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int n = arr.length;
        int ans=Math.min(arr[0], arr[n-1]);
        int low=1, high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]){
                ans=Math.min(ans, arr[mid]);
                return ans;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                ans=Math.min(ans, arr[mid+1]);
                return ans;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                if(arr[mid]>arr[n-1]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return ans;
    }
}
