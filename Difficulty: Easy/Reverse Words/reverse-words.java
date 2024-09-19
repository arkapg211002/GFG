//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        ArrayList<String> strToArr = new ArrayList<>();
        String a = "";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='.'){
                strToArr.add(a);
                a="";
            }else{
            a+=c;
            }
        }
        if(!a.isEmpty()){
            strToArr.add(a);
            a="";
        }for(int i=strToArr.size()-1;i>=0;i--){
            a+=strToArr.get(i);
            if(i!=0){
                a+='.';
            }
        }
        return a;
    }
}

