//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] entry=new int[n];
			for(int i=0;i<n;i++)
				entry[i]=sc.nextInt();
			int[] exit=new int[n];
			for(int i=0;i<n;i++)
				exit[i]=sc.nextInt();
			Solution ob= new Solution();
			int[] res=ob.findMaxGuests(entry,exit,n);
			for(int i=0;i<2;i++){
				System.out.print(res[i]);
			    System.out.print(" ");
			}
			System.out.println();
		}
	}
}

// } Driver Code Ends





//User function Template for Java

class Solution
{
     void merge(int arr[],int l,int m,int r){
        //m=(l+r)/2;
        int left=l;
        int right=m+1;
        ArrayList<Integer> temp = new ArrayList<>();
         while (left <= m && right <= r) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=m){
            temp.add(arr[left]);
            left++;
        }
        while(right<=r){
            temp.add(arr[right]);
            right++;
        }
        for(int i=l;i<=r;i++){
            arr[i]=temp.get(i-l);
        }
        
    }

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r)return;
        int m=(l+r)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
        
    }
	public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        // add code here.
        mergeSort(Entry,0,N-1);
        mergeSort(Exit,0,N-1);
        int[] arr=new int[2];
        int minTime=Entry[0];
        int maxGuest=0;
        int Guest=0;
        int i=0,j=0;
        while(i<N && j<N){
            if(Entry[i]<=Exit[j]){
                Guest++;
                
                if(Guest>maxGuest){
                    maxGuest=Guest;
                    minTime=Entry[i];
                }
                i++;
            }
            else{
                Guest--;
                j++;
            }
        }
        arr[0]=maxGuest;
        arr[1]=minTime;
        return arr;
	}
}