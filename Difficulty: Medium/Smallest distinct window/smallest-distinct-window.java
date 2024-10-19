//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        int n = str.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i < n;i++)
        {
            hm.put(str.charAt(i),1);
        }
        int i=0,j=0,mi = Integer.MAX_VALUE;
        int count = hm.size();
        while(j < n)
        {
            if(hm.containsKey(str.charAt(j)))
            {
                hm.put(str.charAt(j),hm.getOrDefault(str.charAt(j),0)-1);
                if(hm.get(str.charAt(j))==0)
                {
                    count--;
                }
            }
            if(count == 0)
            {
                while(count == 0)
                {
                    mi = Math.min(mi,j-i+1);
                    if(hm.containsKey(str.charAt(i)))
                    {
                        hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
                        if(hm.get(str.charAt(i)) > 0)
                        {
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return mi;
    }
}