//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i) arr[i] = sc.nextInt();

            System.out.println(new Sol().search(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Sol {
    public static int search(int n, int arr[]) {
        
        int count = 1;
          int ans=0;
        HashMap<Integer,Integer> hs = new HashMap<>();
           for(int r : arr){
                if(hs.containsKey(r)){
                    hs.put(r, hs.get(r)+1);
                }
                else{
                hs.put(r,1);
                }
           }
                for(int s : hs.keySet()){
                    if(hs.get(s)==1)
                      ans = s;
                }
                
                
            
           
     return ans;
    }
}