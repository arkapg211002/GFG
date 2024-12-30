//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            Sol obj = new Sol();
            System.out.println(obj.build_bridges(str1,str2));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
        int m=str1.length();
        int n=str2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=Math.max(dp[i][j],1+dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}