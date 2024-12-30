//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            
            ArrayList<ArrayList<Integer>> M = new ArrayList<>();
            
            for(int i=0; i<R; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<C; j++)
                {
                    temp.add(Integer.parseInt(S1[j]));
                }
                M.add(temp);
            }
            
            String S2[] = read.readLine().split(" ");
            int K = Integer.parseInt(S2[0]);
            int Q = Integer.parseInt(S2[1]);
            
            int[] q_i = new int[Q];
            int[] q_j = new int[Q];
            
            String S3[] = read.readLine().split(" ");
            String S4[] = read.readLine().split(" ");
            
            for(int i=0; i<Q; i++)
            {
                q_i[i] = Integer.parseInt(S3[i]);
                q_j[i] = Integer.parseInt(S4[i]);
            }
            
            Solution ob = new Solution();
            ArrayList<Integer> res = ob.largestSquare(M,R,C,K,Q,q_i,q_j);
            
            for(int i=0; i<Q; i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static ArrayList<Integer> largestSquare(ArrayList<ArrayList<Integer>> M, int R, int C, int K, int Q, int[] q_i, int[] q_j) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int dp[][]=new int[R+1][C+1];
        for(int i=0;i<=R;i++){
            int prefix=0;
            for(int j=0;j<=C;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                    continue;
                }
                prefix+=M.get(i-1).get(j-1);
                dp[i][j]=prefix+dp[i-1][j];
            }
        }
        for(int i=0;i<Q;i++){
            int curr=0,low=0,high=Math.min(q_i[i],Math.min(q_j[i],Math.min(C-q_j[i]-1,R-q_i[i]-1)));
            while(low<=high){
                int mid=low+(high-low)/2;
                int row1=q_i[i]-mid;
                int col1=q_j[i]-mid;
                int row2=q_i[i]+mid;
                int col2=q_j[i]+mid;
                if(row1<0 || col1<0 || row2>=R || col2>=C)
                break;
                int bottom=dp[row2+1][col2+1];
                int up=dp[row1][col2+1];
                int left=dp[row2+1][col1];
                int topleft=dp[row1][col1];
                if(bottom-up-left+topleft>K){
                    high=mid-1;
                }
                else{
                    curr=2*mid+1;
                    low=mid+1;
                }
            }
            ans.add(curr);
        }
        return ans;
    }
};