//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int dist_len=set.size();
        int ans=0;
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int left=0;
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            //System.out.println(hm);
            while(hm.size()==dist_len){
                ans+=n-i;
                if(hm.get(arr[left])>1)hm.put(arr[left],hm.get(arr[left])-1);
                else
                   hm.remove(arr[left]);
                   
                left++;
            }
            
        }
        return ans;

    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		
System.out.println("~");
}
	}
}

// } Driver Code Ends