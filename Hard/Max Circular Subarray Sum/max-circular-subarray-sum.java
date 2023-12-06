//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        
        int sum=0;
        
        for(int i=0; i<n; i++)
                sum += a[i];
                
        int curr_max = a[0], max_so_far = a[0], curr_min = a[0], min_so_far = a[0];
    
    for(int i=1; i<n; i++){
        
        curr_max=Math.max(curr_max+a[i], a[i]);
        max_so_far=Math.max(curr_max, max_so_far);
        
        curr_min = Math.min(curr_min + a[i], a[i]);
        min_so_far = Math.min(min_so_far, curr_min);
    }
    
    if(min_so_far == sum)
            return max_so_far;
            
     return Math.max(max_so_far, sum - min_so_far);               
    }
    
}

