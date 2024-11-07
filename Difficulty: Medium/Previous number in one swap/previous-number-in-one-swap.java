//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.previousNumber(S));
        }
    }
}

// } Driver Code Ends




//User function Template for Java
class Solution{
    static String previousNumber(String S){
        // code here
         int n = S.length();
        char arr[] = S.toCharArray();
        int ind1 = -1;
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] > arr[i + 1]){
                ind1 = i;
                break;
            }
        }
        if(ind1 == -1){
            return "-1";
        }
        int ind2 = -1;
        for(int i = ind1 + 1; i <= n - 1; i++){
            if(arr[ind1] > arr[i]){
                if(ind2 == -1){
                  ind2 = i;
                }else if(arr[i] > arr[ind2]){
                    ind2 = i;
                }
            }
        }
        char temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
        String p = new String(arr);
        if(p.charAt(0) == '0'){
            return "-1";
        }
        return p;

    }
}