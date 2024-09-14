//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        List<Integer> pos = new ArrayList<>() , neg = new ArrayList<>();
        for(int i : arr){
            if(i<0) neg.add(i);
            else pos.add(i);
        }
        int i = 0 , j = 0,idx = 0;
        boolean f = false;
        int n = pos.size() , m = neg.size();
        while(idx < arr.size()){
            if(i<n){
                arr.set(idx++, pos.get(i));
                i++;
            }if(j < m){
                arr.set(idx++, neg.get(j));
                j++;
            }
        }
    }
}