//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr1[] = br.readLine().split(" ");
            int[] a = new int[arr1.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);

            String arr2[] = br.readLine().split(" ");
            int[] b = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) b[i] = Integer.parseInt(arr2[i]);

            if (b.length == 1 && b[0] == 0) {
                b = new int[0];
            }
            double res = new Solution().medianOf2(a, b);

            if (res == (int)res)
                System.out.println((int)res);
            else
                System.out.println(res);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public double medianOf2(int a[], int b[]) {
        // Your Code Here
        int i=0;
        int j=0;
        int mid=a.length;
        int num=0;
        int z1=0;
        int z2=0;
        int count=0;
        while(count<=mid &&   (i<a.length || j<b.length))
        {
            if(i<a.length && j<b.length && a[i]<=b[j])
            {
                num=a[i];
                i++;
            }
            else if(i<a.length && j<b.length && a[i]>b[j])
            {
                num=b[j];
                j++;
            }
            else if(i==a.length)
            {
                num=b[j];
                j++;
            }
            else
            {
                num=a[i];
                i++;
            }
            if(count==(mid-1))
            {
                z1=num;
            }
            if(count==mid){
            z2=num;
            }
            count++;
        }
        return (z1+z2)/(2.0);
    }
}