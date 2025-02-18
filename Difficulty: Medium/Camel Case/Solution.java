//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    String[] dict=sc.nextLine().split(" ");
		    String pattern=sc.nextLine();
		    new Solution().findAllWords(dict,pattern);
		    System.out.println();
		    
		
System.out.println("~");
}
		
		
	}


}

// } Driver Code Ends


class Solution
{
    static class TrieNode
    {
	     HashMap<Character, TrieNode> child;
	     boolean isleaf;
	     ArrayList<String> words;
	     public TrieNode() {
	          child = new HashMap<>();
	          isleaf = false;
	          words = new ArrayList<>();
	     }
	     
	     //Function to insert word into the Trie.
	     public void insert(String w) 
	     {
	         TrieNode crawl = this;
	         for(int level = 0; level < w.length(); level++)
	         {
	             char c = w.charAt(level);
	             //considering only uppercase characters.
	             if(Character.isUpperCase(c) == false) 
	             continue;
	             
	             //getting current character position.
	             if(crawl.child.containsKey(c) == false)
	                crawl.child.put(c, new TrieNode());
	             crawl = crawl.child.get(c);
	         }
	         //marking last node as leaf.
	         crawl.isleaf = true;
	         //pushing word into list associated with leaf node.
	         crawl.words.add(w);
	     }
	 }
	
	 //Function to print all children of Trie node root.
	 static void printAll(TrieNode node) 
	 {
	     //if current node is leaf.
	     if(node.isleaf) {
	         Collections.sort(node.words);
	         for(String s : node.words) {
	             System.out.print(s+" ");
	         }
	     }
	     //recursing for all children of root node.
	     for(int i = 0; i < 26; i++) 
	     {
	         char c = (char)('A'+i);
	         if(node.child.containsKey(c)==false)continue;
	         printAll(node.child.get(c));
	     }
	 }
	 
	 //Function to search for pattern in Trie.
	 static boolean search(TrieNode node, String ptrn)
	 {
	     TrieNode crawl = node;
	     for(int i = 0; i < ptrn.length(); i++)
	     {
	         char c = ptrn.charAt(i);
	         //Invalid pattern
	         if(crawl.child.containsKey(c) == false) return false;
	         crawl = crawl.child.get(c);
	     }
	     //printing all words matching that pattern.
	     printAll(crawl);
	     return true;
	 }
	 
	//Function to print all words in the CamelCase dictionary 
    //that matches with a given pattern.
	static void findAllWords(String[] dict, String pattern) 
    {
        //constructing Trie root node.
        TrieNode root=new TrieNode();
        
        //constructing Trie from given dict.
        for(String x:dict)
        root.insert(x);
        
        //searching for pattern in Trie.
        boolean res = search(root, pattern);
    
        System.out.print(res?"":"No match found");
        
    }   
};
