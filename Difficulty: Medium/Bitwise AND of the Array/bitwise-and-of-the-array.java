//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int ans = ob.count(N, A, X); 
            System.out.println(ans);
        
System.out.println("~");
}
    } 
}
// } Driver Code Ends




//User function Template for Java
class Solution 
{ 
    int count(int N, int A[], int X) 
    {   
        int setBitX = 0;
        int ans = N;
        for(int i=30; i>=0; i--){
            if(((1<<i)&X) != 0){
                setBitX |= (1<<i); 
            } else{
                int temp = setBitX | (1<<i);
                int notModified = 0;
                for(int num : A){
                    if((temp&num) == temp){
                        notModified++;
                    }
                }
                ans = Math.min(ans, N-notModified);
            }
        }
        return ans;
    }
} 