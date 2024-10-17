//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            long N = Long.parseLong(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NthTerm(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution

{

    int m=1000000007;

    public void multiply(long a[][], long b[][])

    {

        long mul[][] = new long[2][2];

        for (int i = 0; i < 2; i++)

        {

            for (int j = 0; j < 2; j++)

            {

                mul[i][j] = 0;

                for (int k = 0; k < 2; k++)

                    mul[i][j] += (a[i][k]* b[k][j])%m;

                mul[i][j]%=m;    

            }

        }

        for (int i=0; i<2; i++)

            for (int j=0; j<2; j++)

                a[i][j] = mul[i][j];

    }

    public void power(long a[][],long n)

    {

        long b[][]={{2,5},{1,0}};

        if(n==1)

        return;

        power(a,n/2);

        multiply(a,a);

        if(n%2!=0)

            multiply(a,b);

    }

    public int NthTerm(long N)

    {

        if(N==1 || N==2)

        return 1;

        long a[][]={{2,5},{1,0}};

        power(a,N-2);

        return (int)((a[0][0]+a[0][1])%m);

        // Code here

    }

}