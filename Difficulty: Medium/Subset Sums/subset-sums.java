//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    
    void helper ( ArrayList<Integer> sums, int sum, int ptr,ArrayList<Integer> arr, int n){
            if( ptr == n){
                sums.add(sum);
                return ;
            } else{
                helper( sums, sum+arr.get(ptr), ptr+1, arr,n);
                helper( sums, sum, ptr+1, arr,n);
            }
     }
    
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> sums = new ArrayList<Integer> ();
        
        helper(sums, 0, 0, arr ,n);
        
        return sums;
        
    }
    
}