//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        int l=0,h=S.length()-1;
        ArrayList<String> arr=new ArrayList<>();
        permute(S,l,h,arr);
        Collections.sort(arr);
	    return arr;
	}
	void permute(String s,int l,int h,ArrayList<String> arr){
	    if(l==h){
	        arr.add(s);
	        return;
	    }
	    for(int i=l;i<=h;i++){
	        s=swap(s,l,i);
	        permute(s,l+1,h,arr);
	        s=swap(s,l,i);
	    }
	}
	String swap(String s,int l,int i){
	    char temp;
	    char[] arr=s.toCharArray();
	    temp=arr[l];
	    arr[l]=arr[i];
	    arr[i]=temp;
	    return String.valueOf(arr);
	}
}
