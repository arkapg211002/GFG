//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.newIPAdd(s));
                }
        }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    public String newIPAdd(String S)
    {
        // your code here
        String arr[]=S.split("[.]");
        for(int i=0;i<arr.length;i++){
            String num=arr[i];
            int idx=0;
            while(idx<num.length() && num.charAt(idx)=='0'){
                idx++;
            }
            if(idx==num.length()){
                arr[i]="0";
            }
            else{
                arr[i]=num.substring(idx,num.length());
            }
        }
        String newStr="";
        for(int i=0;i<arr.length-1;i++){
            newStr+=arr[i].concat(".");
        }
        newStr+=arr[arr.length-1];
        return newStr;
    }
}