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
		    String arr[]=new String[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLine();
		        
		    }
		    new Solution().check(arr,n);
		    
		    
		
System.out.println("~");
}
	}


	
}

class Node
{
    public boolean isEndOfWord;
    public TreeMap<Character,Node>mp;
    public Node()
    {
        isEndOfWord=false;
        mp=new TreeMap<>();
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        int count;    
    }
    public static void check(String arr[],int n)
    {
        //Your code here
        TrieNode head = new TrieNode();
        for(int i=0;i<n;i++){
            TrieNode curr = head;
            
            char[] chArr = arr[i].toCharArray();
            
            int m = chArr.length;
            String a = "", name = null;
            for(int j=0;j<m;j++){
                a+=chArr[j];
                int idx = chArr[j]-'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new TrieNode();
                    if(name == null)
                        name = a;
                }
                
                curr = curr.children[idx];
            }
            
            curr.count++;

            if(name == null && curr.isEnd == false){
                name = arr[i];
            }
            else if(name == null && curr.isEnd == true){
                name = arr[i]+ " "+curr.count;
            }
            curr.isEnd = true;
            System.out.println(name);
        }
    }
}