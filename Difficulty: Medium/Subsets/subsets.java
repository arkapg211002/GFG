//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            ArrayList<Integer> A = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                A.add(arr[i]);
            }

            ArrayList<ArrayList<Integer>> res = new Solution().subsets(A);
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            // System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subsetsUtil(a,result,new ArrayList<>(),0);
        
        Collections.sort(result, (list1, list2) -> {
            int size1 = list1.size();
            int size2 = list2.size();
            for (int i = 0; i < Math.min(size1, size2); i++) {
                int cmp = Integer.compare(list1.get(i), list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(size1, size2);
        });
        
        return result;
        
    }
    private static void subsetsUtil(ArrayList<Integer> a ,ArrayList<ArrayList<Integer>> result , ArrayList<Integer> sub , int i){
        if(i==a.size()){
            
            result.add(new ArrayList<>(sub));
            return;
        }
        
        //yes choice
        sub.add(a.get(i));
        subsetsUtil(a,result,sub,i+1);
        //no choice
        sub.remove(sub.size()-1);
        subsetsUtil(a,result,sub,i+1);
        
    }
    
    
}