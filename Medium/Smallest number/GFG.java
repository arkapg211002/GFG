// https://www.geeksforgeeks.org/problems/smallest-number5829/1

//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        int val = (int)Math.pow(10, d-1);
        int n = val*10;
        for(int i=val; i<n; i++) {
            if(sum(i, s)) return String.valueOf(i);
        }
        return "-1";
    }
    
    private boolean sum(int val, int s) {
        int temp = 0;
        while(val>0) {
            temp += val%10;
            val = val/10;
        }
        
        return temp == s;
    }
}
