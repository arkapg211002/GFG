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
            System.out.println(obj.subarrayCount(arr, k));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    
    public static int helpFun(int[] arr , int k , int n)
    {

        if(k == 0) return 0;

        int count = 0 ,left = 0 , right = 0;
        HashMap<Integer , Integer> map = new HashMap<>();

        while(right < n)
        {
            map.put(arr[right] , map.getOrDefault(arr[right],0) + 1);

            while(map.size() > k)
            {
                map.put(arr[left] , map.get(arr[left]) - 1);

                if(map.get(arr[left]) == 0) map.remove(arr[left]);

                left++;
            }

            if(map.size() <= k) count = count + (right - left + 1);

            right++;
        }

        return count;
    }
    
    static int subarrayCount(int arr[], int k) {
        
        int n = arr.length;
        
        return (helpFun(arr , k , n) - helpFun(arr , k - 1 , n));
        
    }
}