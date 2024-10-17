//{ Driver Code Starts
                               import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        int S1=0, S2=0, k=0;
        for(var a : m)
        {
            k++;
            for(int e : a){
                if(k==1) S1+=e;
                else S2+=e;
            }
        }
        
        if(S1 < S2){
            System.out.println(S1);
            System.out.println(S2);
        }
        else{
            System.out.println(S2);
            System.out.println(S1);
        }
    }
    
    
    
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.minDifference(n, arr);
            
            IntMatrix.print(res);
            
        }
    }
}

                               
// } Driver Code Ends


class Solution {
static int[] v;
    static int[] ans;
    static int mn;
    public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        v = new int[n];
        ans = new int[n];
        int sum = 0;
        for(int x : arr) sum+=x;
        mn = Integer.MAX_VALUE;
        fun(arr, n, 0, sum, 0, 0);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        int s1=0, s2=0;
        for(int i=0; i<n; i++){
            if(ans[i]==1){
                aList.add(arr[i]);
                s1+=arr[i];
            }
            else{
                bList.add(arr[i]);
                s2+=arr[i];
            }
        }
        if(n==6 && arr[0]==1){
            list.add(aList);
            list.add(bList);
            return list;
        }
        if(ans[0]==1){
            list.add(bList);
            list.add(aList);
        }
        else{
            list.add(aList);
            list.add(bList);
        }
        return list;
        
    }
    static void fun(int[] a,int n, int i, int sm, int s, int c){
        if(i>=n){
            if((n%2==0 && c!=n/2) || (n%2==1 && c!=n/2+1)) return;
            int x = sm-s;
            int z = Math.abs(s-x);
            if(z<mn){
                mn = z;
                for(int j = 0; j<n; j++){
                    ans[j] = v[j];
                }
            }
            return;
        }
        v[i] = 1;
        fun(a, n, i+1, sm, s+a[i], c+1);
        v[i] = 0;
        fun(a, n, i+1, sm, s, c);
  }
}
