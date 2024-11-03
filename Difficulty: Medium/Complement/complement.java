//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            int v=str.charAt(i)-'0';
            if(v==1) a[i]=-1;
            else a[i]=1;
        }
        int s=0,ms=0;
        int l=0,tl=0,r=-1;
        for(int i=0;i<n;i++)
        {
            s+=a[i];
            //System.out.println(s+" "+l);
            if(s<0) {
                s=0;tl=i+1;
            }
            if(s>ms){
                r=i;ms=s;l=tl;
            }
            
        }
        Vector<Integer> v=new Vector<>(2);
        if(ms==0) {v.add(-1);return v;} 
        v.add(l+1);v.add(r+1);
        return v;
    }
}