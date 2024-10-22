//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);

            for (int i = 0; i < ans.size(); i++) {
                System.out.print("(" + ans.get(i) + ")");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static void recursion(ArrayList<String> ans,String S,StringBuilder sb,int i)
    {

//if index ==length of string -1(last element)then add to ans
        if(i==S.length()-1)
        {
          sb.append(S.charAt(i));
          ans.add(sb.toString());

//remove the last element
          sb.deleteCharAt(sb.length()-1);
          return;
          
        }
        
        recursion(ans,S,sb.append(S.charAt(i)+" "),i+1);
        //remove last 2 added element in backtracking
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        
        recursion (ans,S,sb.append(S.charAt(i)),i+1);

// remove last element
        sb.deleteCharAt(sb.length()-1);
        
        
    }
    
    ArrayList<String> permutation(String S){
        // Code Here
        
        ArrayList<String> ans=new ArrayList<>();
        
        StringBuilder sb=new StringBuilder();
        recursion(ans,S,sb,0);
       
       return ans; 
    }
    
}

