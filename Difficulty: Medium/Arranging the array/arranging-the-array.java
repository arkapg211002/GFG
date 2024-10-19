//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    public void merge( int arr[], int l, int r ){
        
        if(l<r){
            int mid = l+(r-l)/2;
            
            merge(arr,l,mid);
            merge(arr,mid+1,r);
            sort(arr,l,mid,r);
        }
    }
    
    public void sort( int arr[], int l, int mid , int r){
        int l1 = mid -l+1;
        int l2 = r-mid;
        
        int [] leftarr = new int [l1];
        int []rightarr = new int [l2];
        
        for (int i = 0; i < l1; i++) {
            leftarr[i] = arr[l + i];
        }

        
        for (int i = 0; i < l2; i++) {
            rightarr[i] = arr[mid + 1 + i];
        }
        
        int i = 0,j=0;
        int k=l;
        
        while( i<l1 && j<l2){
            if(leftarr[i]<0){
                arr[k]=leftarr[i];
                i++;
            }else if(rightarr[j]<0){
                arr[k]= rightarr[j];
                j++;
            }else{
                break;
            }
            k++;
        }
        
        while(i<l1){
            arr[k++]=leftarr[i++];
        }
        while(j<l2){
            arr[k++]=rightarr[j++];
        }
        
    }
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        merge(a,0,n-1);
        
    }
}

