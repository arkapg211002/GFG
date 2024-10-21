//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
        
        /*
        The intuition behind this approach is to generate each term in the 
        look-and-say sequence by reading and counting the digits
        of the previous term.*/
       if(n == 1){
           return "1";
       }
       if(n == 2){
           return "11";
       }
       
       //because we have to return string we are creating string
       String str ="11";
       for(int i=3;i<=n;i++){
           
           //adding dummy character at end
           str+="$";
           int count = 1;
           
           //to store value and later pass it to string we use this
            StringBuilder sb = new StringBuilder();
            
            for(int j = 1;j<str.length();j++){
                if(str.charAt(j) != str.charAt(j-1)){
                    sb.append(count).append(str.charAt(j-1));
                    //resetting cnt
                    count = 1;
                }else{
                    count++;
                }
            }
            str = sb.toString();
       }
       return str;
    }
}