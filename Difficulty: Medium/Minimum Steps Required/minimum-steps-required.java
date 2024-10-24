//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		
System.out.println("~");
}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
		//Write your code here
		int ac=0;
	    int bc=0;
	    char prev='#';
	    for(int i=0;i<str.length();i++){
	        char ch=str.charAt(i);
	        if(prev==ch){
	            continue;
	        }
	        if(ch=='a'){
	            ac++;
	        }
	        else{
	            bc++;
	        }
	        prev=ch;
	    }
	    return Math.min(ac,bc)+1;
	}
}