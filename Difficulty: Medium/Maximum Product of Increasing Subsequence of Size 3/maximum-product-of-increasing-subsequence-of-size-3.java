//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
	        
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.maxProductSubsequence(arr, N);
        	if(ans.get(0) == -1)
        	    System.out.println("Not Present");
        	else{
        	    for(int i: ans)
        	        System.out.print(i + " ");
        	    System.out.println();
        	}
        	
		}
	}
}



// } Driver Code Ends




//User function Template for Java

class Solution{
    
   
    public static ArrayList<Integer> maxProductSubsequence (int arr[], int n) {
        //Complete the function
        ArrayList<Integer> ans=new ArrayList<>();
        if(n<3)
        {
            ans.add(-1);
            return ans;
        }
        int[] rightLeft =new int[n];
        rightLeft[n-1]=0;
        int max=0;
        for(int i=n-1;i>=0;i--)
        {
            max=Math.max(arr[i],max);
            rightLeft[i]=max;
            
        }
        // int tempMul=Integer.MIN_VALUE;
        long mul=Long.MIN_VALUE;
        int i=0;
        TreeSet<Integer> set=new TreeSet<>();
        
        while(i<=n-1)
        {
            set.add(arr[i]);
            int temp=set.lower(arr[i])!=null?set.lower(arr[i]):-1;
            if(temp!=-1 && arr[i]<rightLeft[i])
            {
                long tempMul=((long)temp*(long)arr[i])*(long)rightLeft[i];
                if(tempMul>mul)
                {
                    mul=tempMul;
                    if(ans.size()>0) ans.removeAll(ans);
                    ans.add(temp);
                    ans.add(arr[i]);
                    ans.add(rightLeft[i]);
                }
            }
            ++i;
        }
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
    
    
}