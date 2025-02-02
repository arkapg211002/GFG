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
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    System.out.println(new Solution().maxSubarrayXOR(arr,n));
		
System.out.println("~");
}
	}
}


// } Driver Code Ends




//User function Template for Java

class TrieNode{
    TrieNode child[]=new TrieNode[2];
    int value = 0;
}
class Solution
{
    //Function to return maximum XOR value.
    public static TrieNode root;
    static int maxSubarrayXOR(int arr[], int n) 
    { 
        //Your code here
         int ans = Integer.MIN_VALUE;
         TrieNode root = new TrieNode();
        int prexor = 0;
        insert(root,0);
        for(int i=0;i<n;i++){
             prexor = prexor^arr[i];
             insert(root,prexor);
             int value = query(root,prexor);
              ans = Math.max(ans,value);
        }
        return ans;
    }
    static void insert(TrieNode root,int num){
        TrieNode curr = root;
        for(int i=31;i>=0;i--){
            int bit = (num & (1<<i)) >=1 ? 1 : 0;
            if(curr.child[bit]==null){
                curr.child[bit] = new TrieNode();
            }
            curr = curr.child[bit];
        }
        curr.value = num;
    }
    static int query(TrieNode root,int num){
        TrieNode curr = root;
        for(int i=31;i>=0;i--){
            int bit = (num & (1<<i)) >=1 ? 1 : 0;
            if(curr.child[1-bit]!=null){
                curr = curr.child[1-bit];
            }
            else if(curr.child[bit]!=null){
                curr = curr.child[bit];
            }
        }
        return num^curr.value;
    }
};