//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public static int SaveGotham(int arr[]) {
        // Complete the function
            Stack<Integer> st=new Stack<>();
        
        int mod=(int)1e9+7;
        int n=arr.length,sum=0;
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=arr[i])
                st.pop();
            sum=(((st.isEmpty())?0:st.peek())+sum)%mod;
            st.push(arr[i]);
        }
        return sum%mod;

        
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
            int res = obj.SaveGotham(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends