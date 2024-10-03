//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

class GfG
{
	public static void main(String[] args)
	{	
	    Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-- > 0)
		{
			String text = sc.next();
			solution x = new solution();
			System.out.println(x.LongestPalindromeSubString(text));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class solution
{
    static String LongestPalindromeSubString(String text)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("^");                         // handling first edge case to stop at index 0 only.
        for(int i=0; i<text.length(); i++){
            sb.append("#");
            sb.append(text.charAt(i));
        }
        sb.append("#$");                    // $ is for handling last index edge case as it should stop at last.
        int[] values = new int[sb.length()];            // it store the max radius of matched chars for current char as center.
        
        int center = 0, last = 0, mirror;
        for(int i=1; i<sb.length(); i++){
            mirror = 2*center - i;                      // getting mirror of current char with previous center.
            
            if(last > i)    values[i] = Math.min(last-i, values[mirror]);       // fetching previous records for current char.
            
            while(i+1+values[i] < sb.length() && sb.charAt(i+1+values[i]) == sb.charAt(i-1-values[i])) values[i]++;      // checking outside from fetechec redius from previous line.
            
            if(i+values[i] > last){
                center = i;
                last = i+values[i];
            }
        }
        
        // getting our answer radius and centre.
        int maxLen = 0;
        for(int i=1; i<values.length; i++){
            if(values[i] > maxLen){
                maxLen = values[i];
                center = i;
            }
        }
        
        int start = (center-maxLen)/2 ;                 // finding the actual starting index of substring.
        
        return text.substring(start, start+maxLen);
    }
}
