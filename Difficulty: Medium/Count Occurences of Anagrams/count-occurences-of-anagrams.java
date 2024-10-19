//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean allZero(int [] arr){
        for(int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }

    int search(String pat, String txt) {
        // code here
        int arr [] = new int [26];
        //for storing the frequince
        for(int i =0; i< pat.length(); i++){
            char ch = pat.charAt(i);
            arr[ch - 'a']++;
        }
        
        int count =0;
        int left =0,right=0;
        while(right != txt.length()){
            arr[txt.charAt(right) - 'a' ]-- ;// if pat contains the same ch then -frequency
            
            if(right - left +1 == pat.length()){ // checking if this is the window
                if(allZero(arr)){ //checking if all frequenci is zero means this is an anagram
                    count++;
                }
                arr[txt.charAt(left) - 'a']++; // deleting first ch freq because of finding next windows
                  left++; // if we are in the windows and all ok then slid to next
            }
            right++; //slid the windows
            
        }
        return count;
    }
}