//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

            Solution obj = new Solution();
            List<List<Integer>> ans = obj.combinationSum2(candidates, k);
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override   public int compare(List<Integer> a, List<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            System.out.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.print("]");
            }
            System.out.println(" ]");
        
System.out.println("~");
}
    }
}
// } Driver Code Ends





class Solution {
    public static void solve(int[] arr, int indx, int n, int target, List<Integer> lst, Set<List<Integer>> resSet) {
        if (target == 0) {
            resSet.add(new ArrayList<>(lst));
            return;
        }

        for (int i = indx; i < n; i++) {
            if (i > indx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            lst.add(arr[i]);
            solve(arr, i + 1, n, target - arr[i], lst, resSet);
            lst.remove(lst.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        Set<List<Integer>> resSet = new HashSet<>();
        List<Integer> lst = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        solve(a, 0, n, s, lst, resSet);
        return new ArrayList<>(resSet);
    }
}