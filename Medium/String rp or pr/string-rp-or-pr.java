//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends




//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    // code here
	    long[] elements;
	    if(X>Y)
	        elements = get('p','r',S);
	    else
	        elements = get('r','p',S);
	        
	    return elements[0]*X + elements[1]*Y;
        
	}
	static long[] get(char c1,char c2,String str){
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        long count1 = 0;
        long count2 = 0;
        
        s1.add(str.charAt(0));
        char temp = str.charAt(0);
        
        for(int i=1; i<str.length(); i++){
            if(!s1.isEmpty() && str.charAt(i) == c2 && s1.peek() == c1){
                s1.pop();
                count1++;
            }
            else
                s1.add(str.charAt(i));
        }
        s2.add(s1.pop());
        
        temp = s2.peek();
        
        while(!s1.isEmpty()){
            if(!s2.isEmpty() && s1.peek() == c2 && s2.peek() == c1){
                count2++;
                s2.pop();
            }
            else{
                s2.add(s1.peek());
            }
            s1.pop();
        }
        if(c1 == 'p')
            return new long[]{count1, count2}; 
        
            return new long[]{count2, count1};
	}
} 
