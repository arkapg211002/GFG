//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class DiverClass {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int Q = Integer.parseInt(str[1]);

            int arr[] = new int[n];
            str = read.readLine().trim().split("\\s+");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(str[i]);

            // RMQ obj = new RMQ();
            long st[] = constructST(arr, n);
            
            for (int i = 0; i < Q; i++) {
                str = read.readLine().trim().split("\\s+");
                char ch = str[0].charAt(0);
                int a = Integer.parseInt(str[1]);
                int b = Integer.parseInt(str[2]);
                Sol g = new Sol();
                if (ch == 'G') {
                    System.out.println(g.getSum(st, n, a, b));
                } else
                    g.updateValue(arr, st, n, a, b);
            }
        
System.out.println("~");
}
    }

    static long st[];

    // construct segment tree
    public static long[] constructST(int arr[], int n) {

        int x = (int)(Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int)(Math.pow(2, x)) - 1;
        st = new long[(int)max_size];
        constructSTUtil(arr, 0, n - 1, st, 0);
        return st;
    }

    public static int getMid(int st, int end) { return (st + (end - st) / 2); }
    
    public static long constructSTUtil(int arr[], int ss, int se, long st[], int si) {
        if (ss == se) {
            st[(int)si] = arr[ss];
            return arr[ss];
        }

        int mid = getMid(ss, se);

        st[(int)si] = constructSTUtil(arr, ss, mid, st, si * 2 + 1) +
                      constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);

        return st[(int)si];
    }
}

// } Driver Code Ends

// User function Template for Java

class Sol
{
    // arr : given array
    // n : size of arr
    // index : need to update
    // new_val : given value to which we need to update index
    // st : constructed segment-tree
    
    //Function to update a value in input array and segment tree.
    static void updateValue(int arr[], long st[], int n, int index, int val) 
    {
        // Your code here
        
        long diff=val-arr[index];
        arr[index]=val;
        update(st,0,n-1,index,0,diff);
    }
    public static void update(long st[],int ss,int se,int i,int si,long diff){
        if( i<ss || i>se ) return ;
        st[si]=st[si]+diff;
        if(se>ss){
            int mid = ss+(se-ss)/2;
            update(st,ss,mid,i,2*si+1,diff);
            update(st,mid+1,se,i,2*si+2,diff);
            return;
        }
    }
    public static long getSum(long st[], int n, int l, int r) 
    {
        // Your code here
        return(f(st,0,n-1,0,l,r));
        
    }
    public static long f(long st[],int ss,int se,int si,int l,int r)
    {
        if(l>se || r<ss) return 0;
        if(ss>=l && se<=r) return st[si];
        
            int mid = ss+(se-ss)/2;
            return(f(st,ss,mid,2*si+1,l,r)+f(st,mid+1,se,2*si+2,l,r));
    }
}