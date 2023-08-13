//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends






class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int N) 
    {
        Stack<Integer> st = new Stack<>();
        int op[] = new int[N];
        
        int ps[] = previousSmaller(arr,N,st);
        st.clear();
        int ns[] = nextSmaller(arr,N,st);
        st.clear();
        
        for(int i=0;i<N;i++)
        {
                int index = ns[i]-ps[i]-2;
                op[index] = Math.max(op[index],arr[i]);
        }
        
        for(int i=N-2;i>=1;i--)
        {
            op[i] = Math.max(op[i+1],op[i]);
        }
        return op;
    }
    
    static int [] previousSmaller(int arr[],int N,Stack<Integer> st)
    {
        int ps[] = new int[N];
        
        for(int i=0;i<N;i++)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
                st.pop();
            
            ps[i] = (st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return ps;
    }
    
    static int [] nextSmaller(int arr[],int N,Stack<Integer> st)
    {
        int ns[] = new int[N];
        
        for(int i=N-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
                st.pop();
                
            ns[i] = (st.isEmpty())?N:st.peek();
            st.push(i);
        }
        return ns;
    }
}