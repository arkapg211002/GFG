// https://www.geeksforgeeks.org/problems/help-nobita0532/1

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        int arr[] = new int[26], count=0;
        for(int i=0;i<s.length();i++) arr[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++)
            if((arr[i]!=0)&&(i+1)%2==(arr[i])%2) count++;
        return count%2==0?"EVEN":"ODD";
    }
}
