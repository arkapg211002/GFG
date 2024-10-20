//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class TrieNode{
    TrieNode[] child=new TrieNode[26];
    int value=0;
}

class Solution
{
    TrieNode root=new TrieNode();
    public void insert(String s){
        TrieNode curr=root;
        for(int j=0;j<s.length();j++){
            int idx=s.charAt(j)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new TrieNode();
            }
            curr=curr.child[idx];
            curr.value=curr.value+1;
        }
        
    }
    public int search(String s){
        TrieNode curr=root;
        for(int j=0;j<s.length();j++){
            int idx=s.charAt(j)-'a';
            if(curr.child[idx]==null){
                return 0;
            }
            curr=curr.child[idx];
        }
        return curr.value;
    }
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        // code here
        if(k>str.length())
            return 0;
        
        TrieNode curr=root;
        for(int i=0;i<n;i++){
            insert(arr[i]);
        }
        String temp=str.substring(0,k);
        return search(temp);
       
        
    }
}