//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");

            Solution obj = new Solution();

            String encodedString = obj.encode(s);
            String decodedStrings[] = obj.decode(encodedString);

            for (String x : decodedStrings) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public String encode(String s[]) {
        // write your logic to encode the strings
        String str="";
        for(int i=0;i<s.length;i++){
            for(int j=0;j<s[i].length();j++){
                str+=s[i].charAt(j);
            }
            str+='@';
        }
        return str;
    }
    public String[] decode(String s) {
        // write your logic to decode the string
        String[] ans=s.split("@");
        return ans;
    }
}