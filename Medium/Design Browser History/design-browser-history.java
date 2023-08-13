//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
    String homepage=bu.readLine();
    BrowserHistory obj=new BrowserHistory(homepage);
    int total_queries=Integer.parseInt(bu.readLine());
    while(total_queries-->0)
     {
         String s[]=bu.readLine().split(" ");
         int query=Integer.parseInt(s[0]);
          if(query == 1) {
            String url=s[1];
            obj.visit(url);
        }
        else if(query == 2) {
            int steps=Integer.parseInt(s[1]);
            System.out.println(obj.back(steps));
        }
        else {
            int steps=Integer.parseInt(s[1]);
            System.out.println(obj.forward(steps));
        }
     }
  }
}
// } Driver Code Ends




//User function Template for Java

class BrowserHistory {
     // constructor to initialize object with homepage
    Stack<String> St = new Stack();
    Stack<String> Q = new Stack();
    String hp;
    BrowserHistory(String homepage) {
        hp=homepage;
        St.push(homepage);
    }
    
    // visit current url
    void visit(String url) {
        St.push(url);
        while(!Q.isEmpty()){
            Q.pop();
        }
    }
    
    // 'steps' move backward in history and return current page
    String back(int steps) {
        for(int i=0;i<steps && St.size()>1 ;i++){ 
            Q.push(St.pop());
        }
        return St.peek();
    }
    
    // 'steps' move forward and return current page
    String forward(int steps) {
        int k=Q.size();
        for(int i=0;i<steps && i<k ;i++) St.push(Q.pop());
        return St.peek();
    }
}