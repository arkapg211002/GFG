//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    static void printSorted(ArrayList<Integer> list)
    {
        for(Integer x : list)
        System.out.print(x + " ");
    }
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0)
		{
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int c = sc.nextInt();
		    
		    int A[] = new int[a];
		    int B[] = new int[b];
		    int C[] = new int[c];
		    
		    for(int i = 0; i < a; i++)
		      A[i] = sc.nextInt();
		      
		    for(int i = 0; i < b; i++)
		      B[i] = sc.nextInt();
		      
		    for(int i = 0; i < c; i++)
		      C[i] = sc.nextInt();
		    
		    printSorted(new Solution().merge3sorted(A, B, C));
		    System.out.println();
		    
		
System.out.println("~");
}
	}
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    // A[], B[], C[]: input arrays
    //Function to merge three sorted lists into a single list.
    static ArrayList<Integer> merge3sorted(int a[], int b[], int c[])
    {
        // add ypur code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 0,j=0,k=0;
        int m = a.length;
        int n = b.length;
        int l = c.length;
        
        while(i<m && j<n && k < l)
        {
            if(a[i] <= b[j] && a[i] <= c[k])
            {
                arr.add(a[i]);
                i++;
            }
            else if(b[j] <= a[i] && b[j] <= c[k])
            {
                arr.add(b[j]);
                j++;
            }
           else if(c[k] <= a[i] && c[k] <= b[j])
            {
                arr.add(c[k]);
                k++;
            }
        }
        if(i<m && j<n)
        {
            merg2sort(arr,a,b,i,j);
            return arr;
        }
       if(j<n && k<l)
        {
            merg2sort(arr,b,c,j,k);
            return arr;
        }
       if(i<m && k<l)
        {
            merg2sort(arr,a,c,i,k);
            return arr;
        }
        while(i<m)
        {
            arr.add(a[i]);
            i++;
        }
        while(j<n)
        {
            arr.add(b[j]);
            j++;
        }
        while(k<l)
        {
            arr.add(c[k]);
            k++;
        }
        return arr;
    }
    static void merg2sort(ArrayList<Integer> arr,int a[],int b[] ,int e,int f)
    {
        int i = e;
        int j = f;
        while(i<a.length && j <b.length)
        {
            if(a[i]<=b[j])
            {
                arr.add(a[i]);
                i++;
            }
            else{
                arr.add(b[j]);
                j++;
            }
        }
        while(i<a.length)
        {
            arr.add(a[i]);
            i++;
        }
        while(j<b.length)
        {
            arr.add(b[j]);
            j++;
        }
    }
}