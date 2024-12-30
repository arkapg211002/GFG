//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java


class Solution {
    public long countEvenSum(int[] arr) {
        // code here
    
        
        int n=arr.length;
        
        long [] even=new long[n];
        long [] odd=new long[n];
        if(arr[0]%2==0){
            even[0]=1;
            odd[0]=0;
        }
        else{
             even[0]=0;
            odd[0]=1;
        }
        
        for(int i=1;i<n;i++){
            
            
            if(arr[i]%2==0){
                even[i]=even[i-1]+1;
                odd[i]=odd[i-1];
            }
            else{
                even[i]=odd[i-1];
                odd[i]=even[i-1]+1;
            }
        }
        
        
        long result=0;
        
        for(int i=0;i<n;i++)
        {
            result+=even[i];
        }
        
        return result;
        
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
            long res = obj.countEvenSum(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends