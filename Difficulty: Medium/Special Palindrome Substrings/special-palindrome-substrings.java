//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    int ans = obj.specialPalindrome(s1,s2);
		    System.out.println(ans);
		    
		    
		    
		
System.out.println("~");
}
	}
}
// } Driver Code Ends




//User function Template for Java


class Solution{
    public static int operations(char[] str,int k,int m)
    {
        int low=0,high=str.length-1;
        int ans=0;
        while(low<high)
        {
            if(str[low]!=str[high])
            {
                if(low>=k && high<=(k+m-1)) return Integer.MAX_VALUE/2;
                
                ans++;
            }
            
            low++; high--;
        }
        
            return ans;
    }
    public  static int specialPalindrome(String a, String b){
       
       int min=Integer.MAX_VALUE/2;
       
       int n=a.length(),m=b.length();
       
       if(n<m) return -1;
       
       for(int i=0;i<=n-m;i++)
       {
           int ans=0;
           char[] tmp=a.toCharArray();
           int k=i;
           for(int j=0;j<m;j++)
           {
               if(tmp[k]==b.charAt(j))
               {
                   k++;
                   continue;
               }
               ans++;
               tmp[k]=b.charAt(j);
               k++;
           }
           
           
           
           ans+=operations(tmp,i,m);
           
           min=Math.min(min,ans);
       }
       
       
        return min==Integer.MAX_VALUE/2?-1:min;
    }
}