//{ Driver Code Starts
import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public int bitonic(List<Integer> arr) {
        // Your Code goes here.
        // int[] arr = li.stream().mapToInt(Integer::intValue).toArray();
        // int ans = 0;
        // int n = li.size();
        // for(int i=0;i<n-1;i++){
        //     int a = 1;
        //     while(i>0&&arr[i]==arr[i-1]){
        //         i--;
        //     }
        //     while(i<n-1&&arr[i]<=arr[i+1]){
        //         a++;
        //         i++;
        //     }
        //     while(i<n-1&&arr[i]>=arr[i+1]){
        //         a++;
        //         i++;
        //     }
        //     ans = Math.max(ans,a);
        //     i--;
        // }
        // return ans;
        
        
        int ans = 0;
        int n = arr.size();
        for(int i=0;i<n-1;i++){
            int a = 1;
            while(i>0&&arr.get(i).equals(arr.get(i-1))){
                i--;
            }
            while(i<n-1&&arr.get(i)<=arr.get(i+1)){
                a++;
                i++;
            }
            while(i<n-1&&arr.get(i)>=arr.get(i+1)){
                a++;
                i++;
            }
            ans = a>ans?a:ans;
            i--;
        }
        return ans;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            List<Integer> arr = new ArrayList<>();
            for (String s : input) {
                arr.add(Integer.parseInt(s));
            }
            Solution sol = new Solution();
            int ans = sol.bitonic(arr);
            System.out.println(ans);
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends