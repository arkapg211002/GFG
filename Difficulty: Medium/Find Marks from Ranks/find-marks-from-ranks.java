//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long q = Long.parseLong(stt.nextToken());
            
            long l[] = new long[(int)(n+5)];
            long r[] = new long[(int)(n+5)];
            long rank[] = new long[(int)(q+5)];
            long storeAnswer[] = new long[(int)(q+5)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < 2*n; i+=2) {
                l[(i/2) + 1] = Long.parseLong(inputLine[i]);
                r[(i/2) + 1] = Long.parseLong(inputLine[i+1]);
            }
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < q; i++) {
                rank[i+1] = Long.parseLong(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            obj.getTestMarks(n, q, r, l, rank, storeAnswer);
            
            StringBuilder output = new StringBuilder();
            for(int i=1;i<=q;i++)
            output.append(storeAnswer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    void getTestMarks(long n, long q, long r[], long l[], long rank[], long storeAnswer[]) {
        TreeMap<Long, Long> rankToMark = new TreeMap<>();
        long currentRank=1;
        
        for (int i=1; i<=n; i++) {
            rankToMark.put(currentRank, l[i]);
            currentRank+=r[i]-l[i]+1;
        }
        
        for (int i=1; i<=q; i++) {
            Map.Entry<Long, Long> entry = rankToMark.floorEntry(rank[i]);
            storeAnswer[i]=entry.getValue()+(rank[i]-entry.getKey());
        }
    }
}