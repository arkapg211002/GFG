//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here


        Arrays.sort(arr);


        if(k<=n)
        {


            int[] subArray = Arrays.copyOfRange(arr, n-k, n);


              for(int i=0;i<k/2;i++)
               {
                 int temp=subArray[k-1-i];
                 subArray[k-1-i]=subArray[i];
                 subArray[i]=temp;
               }
          return subArray;
        }

 

else
         {
            int[] subArray = Arrays.copyOfRange(arr, 0, n);
                for(int i=0;i<n/2;i++)
                   {
                        int temp=subArray[n-1-i];
                        subArray[n-1-i]=subArray[i];
                         subArray[i]=temp;
                    }
         return subArray;
        }


       
    }
}

