//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
/*You are required to complete this method*/

class Solution {

    public long factorial(int n){
      if(n <=1)
        return 1;
      long ans = 1;
      int count = 1;
      while(count <= n){
        ans *= count;
        count++;
      }
      return ans;
    }

    public int getSum(int arr[]) {
        // write code here
        int n = arr.length;
        long sum = 0;
        long fact = factorial(n-1);
        
        for(int i = 0; i<n; i++){
            for(int count = 0; count<n; count++)
            sum+= fact * arr[i] * Math.pow(10, count);
        }
        return (int)(sum % 1000000007);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            int ans = obj.getSum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends