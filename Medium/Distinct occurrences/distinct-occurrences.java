//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int mod = 1000000007;
    int  subsequenceCount(String s, String t)
    {
        // Your code here
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        if(s.charAt(0) == t.charAt(0)){
            dp[0][0] = 1;
        }
        for(int i = 1; i < m; i++){
            if(s.charAt(i) == t.charAt(0)){
                dp[i][0] = 1 + dp[i - 1][0];
            }else{
                dp[i][0] = dp[i - 1][0];
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int count = 0;
                if(s.charAt(i) == t.charAt(j)){
                    int a = dp[i - 1][j - 1]%mod;
                    int b = dp[i - 1][j]%mod;
                    count = (a + b)%mod;
                }else{
                    count = dp[i - 1][j]%mod;
                }
                dp[i][j] = count;
            }
        }
        return dp[m - 1][n - 1]%mod;
    }
}