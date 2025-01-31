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
		    int q=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		        
		    }
		    
		    int[] st=constructSegmentTree(arr); // Array to store segment tree constructSegmentTree(arr); 
		    
		    int type;
		    
		    while(q-->0)
		    {
		        type=sc.nextInt();
		        if(type==0)
		        {
		            int l=sc.nextInt();
		            int r=sc.nextInt();
		            System.out.println(new Solution().findRangeGcd(l, r, st, n));
		        }
		        else
		        {
		            int ind=sc.nextInt();
		            int val=sc.nextInt();
		            new Solution().updateValue(ind, val, arr, st, n);
		        }
		    }
		
System.out.println("~");
}
	}

    /* Function to construct segment tree from given array. 
       This function allocates memory for segment tree and 
       calls constructSTUtil() to fill the allocated memory */
    public static int[] constructSegmentTree(int[] arr) 
    { 
        int height = (int)Math.ceil(Math.log(arr.length)/Math.log(2)); 
        int size = 2*(int)Math.pow(2, height)-1; 
        int []st = new int[size]; 
        constructST(arr,st, 0, arr.length-1, 0); 
        return st; 
    } 
  
    // A recursive function that constructs Segment 
    // Tree for array[ss..se]. si is index of current 
    // node in segment tree st 
    public static int constructST(int[] arr,int st[], int ss, 
                                  int se, int si) 
    { 
        if (ss==se) 
        { 
            st[si] = arr[ss]; 
            return st[si]; 
        } 
        int mid = ss+(se-ss)/2; 
        st[si] = gcd(constructST(arr,st, ss, mid, si*2+1), 
                     constructST(arr,st, mid+1, se, si*2+2)); 
        return st[si]; 
    } 
  
    // Function to find gcd of 2 numbers. 
    private static int gcd(int a, int b) 
    { 
        if (a < b) 
        { 
            // If b greater than a swap a and b 
            int temp = b; 
            b = a; 
            a = temp; 
        } 
  
        if (b==0) 
            return a; 
        return gcd(b,a%b); 
    } 
  
  
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    //Function to find gcd of given range.
    
    public static int gcd(int a,int b){
        //return b==0 ?a : gcd(b,a%b);
        if(a<b){
            int temp=b;
            b=a;
            a=temp;
        }
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
     public static int findRangeGcdUtil(int st[],int ss,int se,int l,int r,int node){
        if(l>se || r < ss){
            return 0;
        }
        
        if(l<=ss && se<=r){
            return st[node];
        }
        
        int mid=(ss+se)/2;
        return gcd(findRangeGcdUtil(st,ss,mid,l,r,2*node+1),findRangeGcdUtil(st,mid+1,se,l,r,2*node+2));
    }
    public static int findRangeGcd(int l, int r, int st[],int n) 
    { 
        //Your code here
        return findRangeGcdUtil(st,0,n-1,l,r,0);
        
    } 
    
    //Function to update a value in input array and segment tree.
    
    public static void updateValueUtil(int index,int new_value,int st[],int ss,int se,int node,int arr[]){
        if(index<ss || index>se){
            return;
        }
        if(ss==se){
           
            st[node]=new_value;
            return;
        }
        int mid=(ss+se)/2;
        if(index<=mid)
            updateValueUtil(index,new_value,st,ss,mid,2*node+1,arr);
        else
            updateValueUtil(index,new_value,st,mid+1,se,2*node+2,arr);
            
        
        st[node]=gcd(st[2*node+1],st[2*node+2]);
    }
    public static void updateValue(int index,int new_val,int arr[],int st[],int n) 
    {
        //Your code here
       arr[index]=new_val;
        updateValueUtil(index,new_val,st,0,n-1,0,arr);
    }
}

