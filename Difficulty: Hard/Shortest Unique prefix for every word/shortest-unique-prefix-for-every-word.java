//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static class TrieNode{
        TrieNode children[];
        boolean isEndOfWord;
        int used;
        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
            used = 0;
        }
    }
    static String[] findPrefixes(String[] arr, int n) {
        TrieNode root = new TrieNode();
        for(String str : arr){
            insert(root, str);
        }
        String[] res = new String[n];
        for(int i = 0;i<n;i++){
            res[i] = search(root, arr[i]);
        }
        return res;
    }
    static String search(TrieNode root, String str) {
        TrieNode curr = root;
        int i = 0;
        for(    ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(curr.used == 1) break;
            curr = curr.children[ch-'a'];
        }
        return str.substring(0, i);
    }
    static void insert(TrieNode root, String str) {
        TrieNode curr = root;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(curr.children[ch-'a'] == null) curr.children[ch-'a'] = new TrieNode();
            curr.used++;
            curr = curr.children[ch-'a'];
        }
        curr.isEndOfWord = true;
    }
};