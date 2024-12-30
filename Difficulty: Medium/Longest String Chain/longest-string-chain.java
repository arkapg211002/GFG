//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    public int longestChain(int n, String words[]){
        //Memoization
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) 
            Arrays.fill(row, 1);
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));

        return findMaxChainOf(0, -1, words, dp);
    }
    
    public int findMaxChainOf(int idx, int prev, String words[], int[][] dp) {
        //base 
        if(idx == words.length)
            return 0;
            
        if(prev!=-1 && dp[prev][idx] != 1)
            return dp[prev][idx];
        
        
        int take = 0;
        if(prev == -1 || isPredecessor(words[prev], words[idx])) {
            take = 1 + findMaxChainOf(idx+1, idx, words, dp);
        }
        
        int skip = findMaxChainOf(idx+1, prev, words, dp);
        
        if(prev != -1)
           return dp[prev][idx] = Math.max(take, skip);
           
        return Math.max(take, skip);
    }
    
    public boolean isPredecessor(String prev, String curr){
        int l1 = prev.length();
        int l2 = curr.length();
        
        if(l1 >l2 || l2 - l1 != 1)
            return false;
        
        int i=0, j=0;
        while(i<l1 && j<l2) {
            if(prev.charAt(i) == curr.charAt(j))
                i++;
            
            j++;
        }
        return (i == l1);
    }
}