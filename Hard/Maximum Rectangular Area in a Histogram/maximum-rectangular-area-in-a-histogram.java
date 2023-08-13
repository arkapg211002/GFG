//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends




class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        Stack<Integer> st=new Stack<>();
        long preSmall[]=new long[(int) n];
        long nextSmall[]=new long[(int) n];
        for(int i=(int)n-1;i>=0;i--){
            while(!st.isEmpty() && hist[st.peek()]>=hist[i]){
                st.pop();
            } 
            if(st.isEmpty()){
                nextSmall[i]=n;
                st.push(i);
            }else{
                long top = st.peek();
                nextSmall[i]=top;
                st.push(i);
            }
        }
        // System.out.println(Arrays.toString(nextSmall));
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && hist[st.peek()]>=hist[i]){
                st.pop();
            } 
            if(st.isEmpty()){
                preSmall[i]=-1;
                st.push(i);
            }else{
                long top = st.peek();
                preSmall[i]=top;
                st.push(i);
            }
        }
        // System.out.println(Arrays.toString(preSmall));
        long max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            long area=(nextSmall[i]-preSmall[i]-1)*hist[i];
            max=Math.max(area,max);
        }
        return max;
    }
        
}




