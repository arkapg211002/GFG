//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    }
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    
            Solution ob = new Solution();
            int ans = ob.solve(a, b, c);
            
            out.println(ans);
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int a, int b, int c) {
        int lar,slar,tlar;
        if(a>=b && a>=c)
        {
            lar=a;
            if(b>=c)
            {
                slar=b;
                tlar=c;
            }
            else
            {
                slar=c;
                tlar=b;
            }
        }
        else if(b>=a && b>=c)
        {
            lar=b;
            if(a>=c)
            {
                slar=a;
                tlar=c;
            }
            else
            {
                slar=c;
                tlar=a;
            }
        }
        else
        {
            lar=c;
            if(a>=b)
            {
                slar=a;
                tlar=b;
            }
            else
            {
                slar=b;
                tlar=a;
            }
        }
        if(lar<=2*(slar+tlar+1))
        return a+b+c;
        else
        return -1;
        
    }
};

