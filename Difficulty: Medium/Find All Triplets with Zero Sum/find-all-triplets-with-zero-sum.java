//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


import java.util.*;

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Step 1: Store indices of each element in the map
        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        // Step 2: Iterate through the array to find triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                int req = -arr[i] - arr[j]; // Calculate required value
                if (mp.containsKey(req)) {
                    for (int x : mp.get(req)) {
                        if (x > i && x < j) { // Ensure i < x < j
                            ans.add(Arrays.asList(i, x, j));
                        }
                    }
                }
            }
        }

        return ans;
    }


}





  




    





 
    


//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends