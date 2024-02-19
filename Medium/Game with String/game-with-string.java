//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
     
     
     HashMap<Character,Integer> hs=new HashMap<>();
     
     for(int i=0;i<s.length();i++)
     {
         if(hs.containsKey(s.charAt(i)))
         {
             hs.put(s.charAt(i),hs.get(s.charAt(i))+1);
         }
         else
         {
             hs.put(s.charAt(i),1);
         }
     }
     int arr[]=new int[hs.size()];
     
     int index=0;
     for(char a:hs.keySet())
     {
         arr[index]=hs.get(a);
         index++;
     }
   
     Arrays.sort(arr);
     int ans=0;
     int j=arr.length-1;
     while(k!=0)
    {
     arr[j]= arr[j]-1;
     Arrays.sort(arr);
     k--;
    }
     for(int i=0;i<arr.length;i++)
     {
         ans+=Math.pow(arr[i],2);
     }
     return ans;
     
    }
}