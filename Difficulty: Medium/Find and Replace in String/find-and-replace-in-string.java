//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            int Q = Integer.parseInt(read.readLine());
            
            int[] index = new int[Q];
            String[] sources = new String[Q];
            String[] targets = new String[Q];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            String S3[] = read.readLine().split(" ");
            
            for(int i=0 ; i<Q ; i++) {
                index[i] = Integer.parseInt(S1[i]);
                sources[i] = S2[i];
                targets[i] = S3[i];
            }

            Solution ob = new Solution();
            System.out.println(ob.findAndReplace(S,Q,index,sources,targets));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static String findAndReplace(String s, int Q, int[] index, String[] sources, String[] targets) {
        // code here
        
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        int n = s.length();
        int replacement = 0;
        int i = 0;
        
        while(i<n){
            if(idx < index.length && i == index[idx]){
                String source = sources[idx];
                if(s.substring(i).startsWith(source) && replacement < Q){
                    sb.append(targets[idx]);
                    i += source.length();
                    replacement++;
                    
                    
                }
                else{
                    sb.append(s.charAt(i++));
                }
                idx++;
                
            }
            else{
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
};