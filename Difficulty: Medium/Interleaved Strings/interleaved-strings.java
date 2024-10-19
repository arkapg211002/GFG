//{ Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


// } Driver Code Ends


/*you are required to complete this method */
class Solution {
public boolean isInterLeave(String a,String b,String c)
{
            //Your code here
            int x=a.length();
            int y=b.length();
            if(x+y!=c.length()){
                return false;
            }
            boolean dp[][]=new boolean[x+1][y+1];
            dp[0][0]= true;
            for(int i=0;i<x+1;i++){
                for(int j=0;j<y+1;j++){
                    if(i>0 && a.charAt(i-1)==c.charAt(i+j-1)){
                        dp[i][j]=dp[i][j] || dp[i-1][j];
                    }
                    if(j>0 && b.charAt(j-1)==c.charAt(i+j-1)){
                        dp[i][j]=dp[i][j] || dp[i][j-1];
                    }
                }
            }
            return dp[x][y];
            
 
}
}
 

