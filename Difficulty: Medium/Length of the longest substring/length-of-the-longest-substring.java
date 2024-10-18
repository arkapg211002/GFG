//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        HashMap<Character, Integer> map = new HashMap<>();
        int len=0;
        int j=-1;
        for(int i=0;i<S.length();i++){
            if(!map.containsKey(S.charAt(i))){
                map.put(S.charAt(i),i);
            }
            else{
                if(j<=map.get(S.charAt(i))){
                    j=map.get(S.charAt(i));
                    map.put(S.charAt(i),i);
                }
                else{
                    map.put(S.charAt(i),i);
                }
            }
            len=Math.max(len,i-j);
        }
        return len;
    }
}