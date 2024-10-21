//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    static int minimumNumberOfSwaps(String S) {
        int o=0, c=0, ub=0, swap=0;
        if(S.isEmpty()){
            return 0;
        }
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '['){
                o++;
                if(ub>0){
                    swap+=ub;
                    ub--;
                }
            }
            else{
                c++;
                ub=c-o;
            }
        }
        return swap;
    }
}