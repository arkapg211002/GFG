https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

```java
//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> lis = new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<m){
            if(arr1[i]==arr2[j]){
                j = rmDup(arr2,j,m,arr1[i]);
                i = add(arr1,i,n,lis);
            }
            else{
                if(arr1[i]<arr2[j])
                    i = add(arr1,i,n,lis);
                else
                    j = add(arr2,j,m,lis);
            }
        }
        while(i<n)
            i = add(arr1,i,n,lis);
        while(j<m)
            j = add(arr2,j,m,lis);

        return lis;
    }
    
    public static int rmDup(int[] arr,int i,int n,int x){
        while(i<n && arr[i]==x)
                i++;
        return i;
    }
    
    public static int add(int[] arr,int i,int n,ArrayList<Integer> lis){
            int x = arr[i];
            lis.add(x);
            return rmDup(arr,i,n,x);
    }
}




```
