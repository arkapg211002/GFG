//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        int jumps=0;
        int currmax=0;
        int maxpos=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(i > maxpos) return -1;
            if(maxpos >= n-1) return jumps;
            if(currmax < i+arr[i]) currmax  = i+arr[i];
            if(i == maxpos)
            {
                maxpos = currmax;
                jumps++;
            }
        }
        return jumps;
    }
}