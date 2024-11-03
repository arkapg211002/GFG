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
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



class Solution {
    static class pair{
        int first;
        int second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    static int maxCoins(int[] A, int[] B, int T, int N) {
        // code here
        ArrayList<pair> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(new pair(A[i],B[i]));
        }
        // list.sort((p1,p2)->{
        //     if(p1.prod==p2.prod){
        //         return p1.first-p2.first;
        //     }
        //     else{
        //         return p2.prod-p1.prod;
        //     }
        // });
        list.sort((p1,p2)->p2.second-p1.second);
        int total=0;
        for(pair p:list){
            int gPlates=p.first;
            int gCoins=p.second;
            if(T<=0){
                break;
            }
            int platesToTake=Math.min(gPlates,T);
            total+=platesToTake*gCoins;
            T=T-gPlates;
        }
        return total;
    }
}