//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        HashMap<String,Long> hm = new HashMap<>();
        int n= str.length();
        int arr[] = new int[n];
        int pc0[]=func(str,'0');
        int pc1[]=func(str,'1');
        int pc2[]=func(str,'2');
        long ans=0;
        hm.put("0@0",1L);
        for(int ep=0;ep<n;ep++)
        {
            int diff1=pc0[ep]-pc1[ep];
            int diff2=pc0[ep]-pc2[ep];
            String diff=diff1+"@"+diff2;
            ans=ans+hm.getOrDefault(diff,0L);
            hm.put(diff,hm.getOrDefault(diff,0L)+1);
        }
        return ans;
        
        
    }
    public static int[] func(String str,char num)
    {
        int count=0;
        int n = str.length();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i)==num)
            {
                count++;
            }
            arr[i]=count;
        }
        return arr;
    }
} 