//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        //Collections.sort(arr);
        //ArrayList<ArrayList<Integer>> lis = new ArrayList<>();
        HashSet<ArrayList<Integer>> lis = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        perm(arr,0,n,lis,ans);
        
        Collections.sort(ans,(a,b)->{
            int s = a.size();
            for(int i=0;i<s;i++){
                if(a.get(i)!=b.get(i))
                    return Integer.compare(a.get(i),b.get(i));
            }
            return Integer.compare(a.get(0),b.get(0));
            
        });
        return ans;
    }
    
    static void perm(ArrayList<Integer> arr,int i,int n,HashSet<ArrayList<Integer>> lis,ArrayList<ArrayList<Integer>> ans){
        if(i==n){
           if(lis.contains(arr))
                return ;
           lis.add(new ArrayList(arr)); 
           ans.add(new ArrayList(arr));
        }
        for(int j=i;j<n;j++){
            swap(arr,i,j);
            perm(arr,i+1,n,lis,ans);
            swap(arr,i,j);
        }
    }
    
    static void swap(ArrayList<Integer> arr,int i,int j){
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
};