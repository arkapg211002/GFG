//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Declared as int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minSwaps(arr));
        }
        scanner.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int minSwaps(int[] arr) {
        // Complete the function
        int count = 0;
        int n = arr.length;
        
        for(int x : arr) count+= x;
        
        if(count == 0)
            return -1;
        
        int maxCount = 0;
        
        int one = 0;
        
        int l = 0;
        int r = 0; 
        
        while(r < n){
            if(r >= count ) {
                maxCount = Math.max(maxCount, one);
                one-=arr[l++];
            }
            one+=arr[r++];
        }
        maxCount = Math.max(maxCount, one);
        
        return (count - maxCount);
        
        
    }
}