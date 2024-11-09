//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length];

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.minMoves(arr));
        }
        scanner.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int minMoves(int[] arr) {
        // code here
        int n=arr.length;
        int[] ld=new int[n];
        int[] rd=new int[n];
        int d=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(d!=Integer.MAX_VALUE) d++;
            if(arr[i]==1){
                d=0;
            }
            else{
                ld[i]=d;
            }
        }
        if(d==Integer.MAX_VALUE) return -1;
        d=Integer.MAX_VALUE;
        for(int i=n-1;i>-1;i--){
            if(d!=Integer.MAX_VALUE) d++;
            if(arr[i]==1){
                d=0;
            }
            else{
                rd[i]=d;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int a=Math.min(ld[i],rd[i]);
            ans=Math.max(a,ans);
        }
        return ans;
    }
}