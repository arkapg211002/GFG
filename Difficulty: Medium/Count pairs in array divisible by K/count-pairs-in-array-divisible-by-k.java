//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static long countKdivPairs(int arr[], int n, int k) {
        //code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int a: arr) {
            int rem = a % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        long count = 0L;
        
        for (int a: arr) {
            int rem = a % k;
            if (rem == 0) {
                count += map.get(rem) - 1;
                continue;
            }
            int diff = k - rem;
            count += map.getOrDefault(diff, 0);
            if (diff == rem) count -= 1;
        }
        
        return count / 2;
    }
}