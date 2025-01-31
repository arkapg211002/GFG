//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		long t=sc.nextInt();
		while(t-->0)
		{
		    int num,query;
		    
		    num=sc.nextInt();
		    query=sc.nextInt();
		    long arr[]=new long[num];
		    
		    for(int i=0;i<num;i++)
		    arr[i]=sc.nextInt();
		    
		    long st[]=constructST(arr, num);
		    int L,R,index,val;
		    
		    
		  
		    
		    while(query-->0)
		    {
		        char type=sc.next().charAt(0);
		        if(type=='G')
		        {
		            
		            L=sc.nextInt();
		            R=sc.nextInt();
		            
		            System.out.println(getLCM(st, arr, num, L, R));
		        }
		        else if(type=='U')
		        {
		            index=sc.nextInt();
		            val=sc.nextInt();
		            updateValue(arr, st, num, index, val);
		        }
		    }
		
System.out.println("~");
}
	}
	
	public static int getMid(int s,int e)
	{
	    return s + (e - s) / 2;
	}

	
	static long gcd(long a, long b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
      
    // method to return LCM of two numbers 
    static long LCM(long a, long b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
	
	public static void constructSTUtil(long arr[], int ss, int se, long st[], int si)
	{
	    if (ss == se) {
        st[si] = arr[ss];
        return;
	    }
	    int mid = getMid(ss, se);
        constructSTUtil(arr, ss, mid, st, si * 2 + 1);
        constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);
        st[si] = LCM(st[si * 2 + 1], st[si * 2 + 2]);
        
	}
	
	public static long [] constructST(long arr[],int n)
	{
	    int x=(int) Math.ceil(Math.log(n)/Math.log(2));
	    int max_size = 2 * (int)Math.pow(2, x) - 1;
	    long st[]=new long[max_size];
	    constructSTUtil(arr, 0, n - 1, st, 0);
	   
        return st;
	}

// } Driver Code Ends
//User function Template for Java

// arr : given array
// n : size of the array
// qs and qe are L and R respectively given in the problem to denotes range
// st : segment tree of the array arr

private static long lcm(long a, long b){
    return (a * b) / gcd(a, b);
}

//Function to find LCM of given range.
public static long getLCM(long st[], long arr[], int n, int qs, int qe)
{
    //Your code here
    return getLcmRec(st, 0, n - 1, 0, qs, qe);
}

private static long getLcmRec(long[] st, int start, int end, int index, int qStart, int qEnd){
    // outside
    if(start > qEnd || end < qStart)
        return 1;
    // inside
    if(start >= qStart && end <= qEnd)
        return st[index];
    // partial
    int mid = (start + end) / 2;
    return lcm(getLcmRec(st, start, mid, 2 * index + 1, qStart, qEnd), getLcmRec(st, mid + 1, end, 2 * index + 2, qStart, qEnd));
}

//Function to update a value in input array and segment tree.
public static void updateValue(long arr[],long st[],int n,int index,long new_val)
{
    //Your code here
    updateValueRec(st, 0, n - 1, 0, index, new_val);
}

private static long updateValueRec(long[] st, int start, int end, int index, int qIndex, long newVal){
    // outside
    if(start > qIndex || end < qIndex)
        return st[index];
    // inside
    if(start == end)
        return st[index] = newVal;
    // partial
    int mid = (start + end) / 2;
    return st[index] = lcm(updateValueRec(st, start, mid, 2 * index + 1, qIndex, newVal), updateValueRec(st, mid + 1, end, 2 * index + 2, qIndex, newVal));
}







//{ Driver Code Starts.


}
// } Driver Code Ends