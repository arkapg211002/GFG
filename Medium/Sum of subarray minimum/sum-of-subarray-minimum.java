//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int sumSubarrayMins(int N, int[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
        int mod=(int)(1e9+7);
        int[] nsl=new int[N];
        int[] nsr=new int[N];
        
        for(int i=0;i<N;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) nsl[i]=-1;
            else nsl[i]=st.peek();
            st.push(i);
        }
        
        st.clear();
        
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            if(st.isEmpty()) nsr[i]=N;
            else nsr[i]=st.peek();
            st.push(i);
        }
        
        long sum=0;
        
        for(int i=0;i<N;i++){
            int left=i-nsl[i];
            int right=nsr[i]-i;
            long total=(((left*right)%mod)*arr[i])%mod;
            sum+=(total%mod);
        }
        return (int)(sum%mod);
    }
}
