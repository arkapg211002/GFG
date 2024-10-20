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
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     
    static ArrayList<String> ans;
    
    static class TrieNode{
        
        TrieNode child[]=new TrieNode[26];
        ArrayList<String> value=new ArrayList<>();
        boolean isEnd;
        
    }
    
    static void insert(String s,TrieNode head){
        
        TrieNode curr=head;
        for(int i=0;i<s.length();i++){
            int index=-1;
            char a=s.charAt(i);
            if(a>=65 && a<=90){
                index=s.charAt(i)-'A';
            }
            if(index!=-1 && curr.child[index]==null){
                curr.child[index]=new TrieNode();
                curr=curr.child[index];
            }
            else if(index!=-1 && curr.child[index]!=null){
                curr=curr.child[index];
            }
        }
        
        curr.isEnd=true;
        curr.value.add(s);
        
    }
    
    static void printAllPattern(TrieNode head){
        //To print Lexicographically : just do preorder traversal of trie 
        if(head==null){
            return ;
        }
        
        if(head.isEnd==true){
            int k=head.value.size();
            if(k==1){
                ans.add(head.value.get(0));
            }
            else{
                for(int i=0;i<k;i++){
                    ans.add(head.value.get(i));
                }
            }
        }
        
        for(int i=0;i<26;i++){
            if(head.child[i]!=null){
                printAllPattern(head.child[i]);
            }
        }
    }
    
    static boolean searchPat(TrieNode head,String s){
        
        TrieNode curr=head;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'A';
            if(curr.child[index]==null){
                return false;
            }
            curr=curr.child[index];
        }
        
        printAllPattern(curr);
        return true;
        
    }

    ArrayList<String> CamelCase(int N,String[] dict,String pattern){
        
        TrieNode head=new TrieNode();
        for(int i=0;i<dict.length;i++){
            insert(dict[i],head);
        }
        
        ans=new ArrayList<String>();
        if(searchPat(head,pattern)){
            Collections.sort(ans);
            return ans;
        }
        else{
            ans.add("-1");
            return ans;
        }
        
    }
}