//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<Integer> ans = ob.extraCount(s);
            System.out.println("R"+ans.get(0)+"B"+ans.get(1)+"Y"+ans.get(2)+"G"+ans.get(3));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> extraCount(String s){
        List<Integer> res = new ArrayList<>();
        int red = 0, green = 0, blue = 0, yellow = 0, not = 0, n = s.length();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='R') red++;
            else if(s.charAt(i)=='G') green++;
            else if(s.charAt(i)=='B') blue++;
            else if(s.charAt(i)=='Y') yellow++;
            else if(s.charAt(i)=='!') not++;
        }
        if(not == 0){
            res.add(0);
            res.add(0);
            res.add(0);
            res.add(0);
        }else{
            if(red==0) res.add(0); else res.add(n/4 - red);
            if(blue==0) res.add(0); else res.add(n/4 - blue);
            if(yellow==0) res.add(0); else res.add(n/4 - yellow);
            if(green==0) res.add(0); else res.add(n/4 - green);
        }
        return res;
    }
}