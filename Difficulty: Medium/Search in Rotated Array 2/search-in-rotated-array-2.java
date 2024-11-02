//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public static boolean Search(int[] arr, int key) {
        int n=arr.length;
        int l=0,h=n-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(arr[mid]==key)
                return true;
            if(arr[mid]==arr[l] && arr[mid]==arr[h])
            {
                l=l+1;
                h=h-1;
                continue;
            }
            if(arr[mid]>=arr[l])
            {
                if(arr[l]<=key && arr[mid]>=key)
                    h=mid-1;
                else
                    l=mid+1;
            }
            else
            {
                if(arr[mid]<=key && arr[h]>=key)
                {
                    l=mid+1;
                }
                else
                    h=mid-1;
            }
        }
        return false;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            boolean res = obj.Search(arr, k);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            // System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends