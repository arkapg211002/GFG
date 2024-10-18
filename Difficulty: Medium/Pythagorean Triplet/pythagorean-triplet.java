//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,arr[i]);
        }
        int[] count=new int[max+1];
        Arrays.fill(count,0);
        
        for(int i=0;i<n;i++)
        {
            count[arr[i]]=count[arr[i]]+1;
        }
        // Step 3: Check for the Pythagorean triplet
        for (int i = 0; i < max+1; i++) {
            for (int j = i + 1; j < max+1; j++) {
                // If a^2 + b^2 is found in the HashSet, we have a triplet
                if(count[i]==0) 
                {
                    
                    break;
                }
                
                if (count[j]==0) {
                    continue;
                }
                int d=i*i+j*j;
                double drt=Math.sqrt(d);
                int irt=(int)Math.sqrt(d);
                if(drt==irt && irt<=max && count[irt]>0)
                   return true;
            }
        }
        return false;
    }
}