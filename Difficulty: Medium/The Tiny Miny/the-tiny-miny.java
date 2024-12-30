//{ Driver Code Starts
import java.util.Scanner;


// } Driver Code Ends


import java.util.*;

//User function Template for Java


class Solution{
    // Function for finding maximum and value pair
    public static String tinyMiny (int a, int n) {
        //Complete the function
       String s="";
       for(int i=1;i<=n;i++)
       {
           s+=Integer.toString((int)Math.pow(a,i));
       }
       char ch[]=s.toCharArray();
       Arrays.sort(ch);
       String st="";
       String r="^0+()";
       for(int i=0;i<ch.length;i++)
       {
           st=st+ch[i];
       }
       st=st.replaceAll(r,"");
       return st;
        
    }
    
    
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int n = scanner.nextInt();
            Solution solution = new Solution();
            System.out.println(solution.tinyMiny(a, n));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends