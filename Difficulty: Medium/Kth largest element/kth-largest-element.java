//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            int k = Integer.parseInt(br.readLine());
            System.out.println(new Solution().KthLargest(a, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends








class Solution {
    // Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int k) {
        // Your code here
        //buildHeap
        int n=arr.length;
        buildHeap(arr,n);
        //logk
        for(int i=n-1;i>(n-k);i--){
            swap(arr,i,0);
            heapify(arr,i,0);
        }
        return arr[0];
    }
    static void buildHeap(int arr[],int n){
        for(int i=(n-2)/2;i>=0;i--){
            heapify(arr,n,i);
        }
    }
    static void heapify(int arr[],int n,int i){
        int lar=i;
        int l=2*i+1,r=2*i+2;
        if(l<n && arr[l]>arr[lar]) lar=l;
        if(r<n && arr[r]>arr[lar]) lar=r;
        if(lar!=i){
            swap(arr,i,lar);
            heapify(arr,n,lar);
        }
    }
    static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}