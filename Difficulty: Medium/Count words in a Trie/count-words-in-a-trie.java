//{ Driver Code Starts
import java.io.*;
import java.util.*;

class TrieNode {

    private final int ALPHABET_SIZE = 26;
    public TrieNode[] children;
    public boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[ALPHABET_SIZE];
        isLeaf = false;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }
}

public class Main {
    private static void insert(TrieNode root, String key) {
        int length = key.length();

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isLeaf = true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");

            TrieNode root = new TrieNode();
            for (int i = 0; i < s.length; i++) {
                insert(root, s[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.wordCount(root));
        }
    }
}
// } Driver Code Ends




class Solution {
    
    public int wordCount(TrieNode root) {

        
         int cnt = provideCnt(root , 0);
         return cnt;
        

    }
    
    private int provideCnt(TrieNode node , int cnt){
        for(int i = 0; i < 26; i++){
            TrieNode temp = node.children[i];
            
            if(temp == null){
                continue;
            }
            
            if(temp.isLeaf){
                cnt++;
            }
            
            cnt = provideCnt(temp , cnt);
            
        }
        
        return cnt;
        
        
    }
}