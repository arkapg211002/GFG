//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution {
    public static int countSubstring(String s) {
        // code here
        int n=s.length();
        int ca=-1,cb=-1,cc=-1,a=-1,b=-1,c=-1,cnt=0;
        for(int j=0;j<n;j++)
        {
            if(s.charAt(j)=='a')
            {
                a=j;
                ca++;
            }
            else if(s.charAt(j)=='b')
            {
                b=j;
                cb++;
            }
            else if(s.charAt(j)=='c')
            {
                c=j;
                cc++;
            }
            if(ca>=0 && cb>=0 && cc>=0)
            {
                int min=Math.min(Math.min(a,b),c);
                cnt+=(min+1);
            }
        }
        return cnt;
    }
}
        
