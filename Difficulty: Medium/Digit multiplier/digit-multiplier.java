//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getSmallest(N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static String getSmallest(Long N) {
    long n=N;
    ArrayList<Long> a=new ArrayList<>();
        while(n>10){
                if(n%9==0){ a.add(9l);n/=9;}
                else if(n%8==0){ a.add(8l);n/=8;}
                else if(n%7==0){ a.add(7l);n/=7;}
                else if(n%6==0){ a.add(6l);n/=6;}
                else if(n%5==0){ a.add(5l);n/=5;}
                else if(n%4==0){ a.add(4l);n/=4;}
                else if(n%3==0){ a.add(3l);n/=3;}
                else if(n%2==0){ a.add(2l);n/=2;}
                else return Integer.toString(-1);
        }
        a.add(n);
        Collections.sort(a);
    StringBuilder sb=new StringBuilder();
    for(long i:a)sb.append(i);
    return sb.toString();
    }
};