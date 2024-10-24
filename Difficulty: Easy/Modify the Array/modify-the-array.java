//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        int j=0;
        while(j<arr.length-1){
            if(arr[j]==arr[j+1]){
                arr[j]=2*arr[j];
                arr[j+1]=0;
                j+=2;
            }else{
                j++;
            }
        }
        ArrayList<Integer>al=new ArrayList<>();
        int zeros=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                al.add(arr[i]);
            }else{
                zeros++;
            }
        }
        for(int i=0;i<zeros;i++){
            al.add(0);
        }
        return al;
    }
}