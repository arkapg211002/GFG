//{ Driver Code Starts
// Initial template for JAVA

import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();
            int k = sc.nextInt();
            Solution ob = new Solution();
            if (ob.areKAnagrams(str1, str2, k) == true)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends

// User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length()!=s2.length()){
            return false;
        }
        // code here
        Map<Character,Integer> h1=new HashMap<>();
      
        int n=s1.length();
        for(int i=0;i<n;i++){
            char ch=s1.charAt(i);
           h1.put(ch,h1.getOrDefault(ch,0)+1);
           
        }
        for(int i=0;i<n;i++){
            char ch=s2.charAt(i);
            if(h1.containsKey(ch)){
                h1.put(ch,h1.get(ch)-1);
                if(h1.get(ch)==0){
                    h1.remove(ch);
                }
            }
        }
        int mismatches = 0;
        for (int value : h1.values()) {
            mismatches += value;
        }
        return mismatches<=k?true:false;
    }
}
