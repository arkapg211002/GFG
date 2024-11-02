//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
/*Complete the function below*/
/*Complete the function below*/

class Solution {
    // Function to return maximum sum subarray by removing at most one element.
    public static int maxSumSubarray(int arr[]) {
        int n = arr.length;
        int []dpPre = new int[n];
        int []dpSuf = new int[n];
        
        int sum=0, max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum<0) sum=0;
            dpPre[i]=sum;
            max=Math.max(max,arr[i]);
        }
        
        sum=0;
        for(int j=n-1; j>=0; j--){
            sum+=arr[j];
            if(sum<0) sum=0;
            dpSuf[j]=sum;
        }
        
        int ans=Integer.MIN_VALUE;
        for(int i=-1; i<=n; i++){
            ans = Math.max(ans,
                ((i-1>=0)?dpPre[i-1]:0)+((i+1<n)?dpSuf[i+1]:0)
                +((i>=0 && i<n && arr[i]>0)?arr[i]:0)
            );
        }

        if(ans==0) ans=max;
        return ans;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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
            int res = obj.maxSumSubarray(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends