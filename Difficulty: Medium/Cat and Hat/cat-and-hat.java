//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String str;
            str = br.readLine();

            Solution obj = new Solution();
            boolean res = obj.cat_hat(str);

            System.out.println(res ? "True" : "False");
        }
    }
}

// } Driver Code Ends



class Solution {
    public static boolean cat_hat(String str) {
        int cat = 0;
        int hat = 0;

        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals("cat")) {
                cat++;
            }
            if (str.substring(i, i + 3).equals("hat")) {
                hat++;
            }
        }

        return cat == hat;
    }
}
