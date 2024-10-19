//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        List<Character> upperCase = new ArrayList<>();
        List<Character> lowerCase = new ArrayList<>();
        
        for(char ch : str.toCharArray()){
            if(Character.isUpperCase(ch)){
                upperCase.add(ch);
            } else {
                lowerCase.add(ch);
            }
        }
        
        Collections.sort(upperCase);
        Collections.sort(lowerCase);
        
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isUpperCase(ch)){
                sb.append(upperCase.get(i++));
            } else {
                sb.append(lowerCase.get(j++));
            }
        }
        
        return sb.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends