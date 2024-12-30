//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static String moveRobots(String s1, String s2){
        String s1bots=s1.replace("#","");
        String s2bots=s2.replace("#","");
        if(!s1bots.equals(s2bots)){
            return "No";
        }
        int i=0;
        int j=0;
        int n=s1.length();
        while(i<n && j<n){
            while(i<n && s1.charAt(i)=='#'){
                i++;
            }
            while(j<n && s2.charAt(j)=='#'){
                j++;
            }
            if(i<n && j<n){
                if(s1.charAt(i)=='A' && i<j){
                    return "No";
                }
                if(s1.charAt(i)=='B' && i>j){
                    return "No";
                }
                i++;
                j++;
            }
        }
        return "Yes";
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s1=read.readLine();
            String s2=read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.moveRobots(s1, s2));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends