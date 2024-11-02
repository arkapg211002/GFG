//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[] = new int[N];
            for (int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            String[] input = new String[2];
            input = read.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);

            Solution ob = new Solution();
            System.out.println(ob.countTriplets(Arr, N, L, R));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static int countTriplets(int Arr[], int N, int L, int R) {
        return countTriplets_lessThanX(Arr, N, R) - countTriplets_lessThanX(Arr, N, L-1); 
    }
    
    static int countTriplets_lessThanX(int Arr[], int N, int X){
        int count=0;
        Arrays.sort(Arr);
        for(int i=0; i<N-2; i++){
            int l=i+1, r=N-1;
            while(l<r){
                if(Arr[i]+Arr[l]+Arr[r]<=X){
                    count+= r-l;
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}