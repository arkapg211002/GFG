//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{

    public static int[] calculateSpan(int price[], int n)
    {
        int[] s=new int[n];
        Stack<Integer> st= new Stack<Integer>();
        s[0]=1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && price[st.peek()]<=price[i]){
                st.pop();
            }
            if(st.isEmpty()){
                s[i]=i+1;
            }
            else{
                s[i]=i-st.peek();
            }
            st.push(i);
        }
        return s;
    }
    
}