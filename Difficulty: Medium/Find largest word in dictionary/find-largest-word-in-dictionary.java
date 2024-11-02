//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().split(" ");
            List<String> d = new ArrayList<String>();
            for (int i = 0; i < n; i++) d.add(input_line[i]);

            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findLongestWord(S, d));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    static String findLongestWord(String S, List<String> d) {
        // code here
        
      String longestword="";
      for(String word :d)
      {
         
          int wordidx=0;
          int target=0;
          while(wordidx<word.length() && target<S.length())
          {
              if(word.charAt(wordidx)==S.charAt(target))
              wordidx++;
              
             target++;
           } 
           
           if(wordidx==word.length())
           {
              if(word.length()>longestword.length())
              longestword=word;
              else if(longestword.length()==word.length() && word.compareTo(longestword)<1)
              longestword=word;
            } 
        }
        
           return longestword;
      
    }
}