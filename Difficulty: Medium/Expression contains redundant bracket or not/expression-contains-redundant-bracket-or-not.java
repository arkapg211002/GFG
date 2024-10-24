//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int checkRedundancy(String s) {
        // co,de here
        Stack<Character> st = new Stack<>(); //creating a stack
        char[] str = s.toCharArray(); // breaking up of characters
        for(char ch: str){ //traversing
            if(ch==')'){ //ifthe condition is meet , starting putting it in stack ) cause last in first out principle is followed by stack.
                char top = st.peek(); 
                st.pop();
            boolean flag = true; // give a flag 
            while(top != '('){ // chcekfor this condition
                if (top == '+' || top == '-'
                            || top == '*' || top == '/') { // check if there are operaors or not
                                flag = false;
            }
           top = st.peek();
           st.pop();
        }
           if(flag == true){ // statement for printing out the element
               return 1;
           } 
        }else {
            st.push(ch);
        }
        }
        return 0;
        
    }
}  
