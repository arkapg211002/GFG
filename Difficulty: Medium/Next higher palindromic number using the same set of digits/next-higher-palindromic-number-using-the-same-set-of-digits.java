//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        
System.out.println("~");
}
            
    }
}

// } Driver Code Ends




//User function Template for Java

// import java.util.Arrays;

class Solution {
    public static String nextPalin(String N) {
        int n = N.length();
        if (n <= 1) return "-1"; // Single digit can't have a next higher palindromic number

        // Split the number into left and right half
        String leftHalf = N.substring(0, n / 2);
        char[] leftHalfArr = leftHalf.toCharArray();

        // Find the next permutation of the left half
        if (!nextPermutation(leftHalfArr)) return "-1"; // No higher permutation

        // Form the new palindromic number
        String newLeftHalf = new String(leftHalfArr);
        StringBuilder newPalin = new StringBuilder(newLeftHalf);
        if (n % 2 != 0) newPalin.append(N.charAt(n / 2)); // Middle character for odd length
        newPalin.append(new StringBuilder(newLeftHalf).reverse().toString());

        String newPalinStr = newPalin.toString();
        return newPalinStr.compareTo(N) > 0 ? newPalinStr : "-1";
    }

    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        swap(arr, i, j);

        reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }


}
