//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter ot = new PrintWriter(System.out);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.printUniqueSubsets(nums);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
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
            ot.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                ot.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    ot.print(ans.get(i).get(j) + " ");
                ot.print("]");
            }
            ot.println(" ]");
        }
        ot.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        f(nums,0,new ArrayList<Integer>(),ans);
        return ans;
        
    }
    public static void f(int[] nums, int index, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> ans){
        if(index >= nums.length){
           // Collections.sort(subset);
            //System.out.println(subset);
            if(!doesNotContains(ans,subset)){
               // System.out.println(subset);
                ans.add((ArrayList<Integer>)subset.clone());
            }
            return;
        }
        
        subset.add(nums[index]);
        f(nums,index+1,subset,ans);
        subset.remove((Integer)nums[index]);
        f(nums,index+1,subset,ans);
    }
    
    public static boolean doesNotContains(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> subset){
        
        for(ArrayList<Integer> list : ans){
            boolean flag = false;
            if(subset.size() == list.size()){
                for(int i=0;i<list.size();i++){
                    if(subset.get(i)!=list.get(i)){
                        flag=false;
                        break;
                    }else{
                        flag=true;
                    }
                }
                if(flag==true){
                    return true;
                }
            }
            
        }
        return false;
        
    }
}