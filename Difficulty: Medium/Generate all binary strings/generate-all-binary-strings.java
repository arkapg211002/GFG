//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    public static void generate(int i,int n,char ch[],List<String> ans)
    {
        if(i==n)
        {
            String str=new String(ch);
            if(str.contains("11")==false)
            {
                ans.add(str);
            }
        }
        else
        {
            ch[i]='0';
            generate(i+1,n,ch,ans);
            ch[i]='1';
            generate(i+1,n,ch,ans);
        }
    }
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List<String> ans=new ArrayList<>();
    char ch[]=new char[n];
    generate(0,n,ch,ans);
    return ans;
  }
}
     
       
     