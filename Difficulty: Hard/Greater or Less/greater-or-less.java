//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public static int[] greaterLesser(int[] A, int N){
        int[] left = solve(A, N);
        
        // creating a temporary array for storing the negation of elements in A
        int[] temp = new int[N];
        for (int i = 0; i < N; i++)
            temp[i] = -A[N - i - 1];
        
        // solving the problem for the negated array
        int[] right = solve(temp, N);
        
        // calculating the absolute difference between the left and right values 
        int[] ans = new int[N];
        for (int i = 0; i < N; i++)
            ans[i] = Math.abs(left[i + 1] - right[N - i]);
        
        // returning the result
        return ans;

    }

    static int[] solve(int arr[], int n) {
        // creating an array A of size n+1
        int[] A = new int[n + 1];
        
        // creating a TreeMap for storing unique elements and their count
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n; i++)
            mp.put(arr[i], 0);
        
        // assigning unique indices to the unique elements in the TreeMap
        int c = 0;
        for (Map.Entry<Integer, Integer> e : mp.entrySet())
            mp.put(e.getKey(), ++c);
        
        // assigning the unique indices to the array A
        for (int i = 1; i <= n; i++)
            A[i] = mp.get(arr[i - 1]);
        
        // creating an array res of size n+1 and initializing a segment tree
        int res[] = new int[n + 1];
        Seg_Tree ob = new Seg_Tree(n, arr);
        
        // updating the segment tree and storing the results in the array res
        for (int i = 1; i <= n; i++) {
            ob.update(A[i], 1);
            res[i] = ob.query(A[i]);
        }
        
        // returning the result
        return res;
    }

    static class Seg_Tree {
        int tree[], arr[];
        int n;

        public Seg_Tree(int n, int arr[]) {
            this.arr = arr;
            this.n = n;
            tree = new int[4 * n + 4];
        }

        // building the segment tree
        void build(int s, int e, int idx) {
            if (s == e) {
                tree[idx] = arr[s];
                return;
            }

            int mid = s + (e - s) / 2;
            build(s, mid, 2 * idx);
            build(mid + 1, e, 2 * idx + 1);

            tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
        }

        // updating the segment tree
        void update(int pos, int v, int s, int e, int idx) {
            if (pos < s || pos > e)
                return;

            if (s == e) {
                tree[idx]++;
                return;
            }

            int mid = s + (e - s) / 2;
            update(pos, v, s, mid, 2 * idx);
            update(pos, v, mid + 1, e, 2 * idx + 1);

            tree[idx] = (tree[2 * idx] + tree[2 * idx + 1]);
        }

        void update(int pos, int v) {
            update(pos, v, 1, n, 1);
        }

        // querying the segment tree
        int query(int qs, int qe, int s, int e, int idx) {
            if (qs <= s && qe >= e)
                return tree[idx];

            if (qs > e || qe < s)
                return 0;

            int mid = s + (e - s) / 2;
            return query(qs, qe, s, mid, 2 * idx) + query(qs, qe, mid + 1, e, 2 * idx + 1);
        }

        int query(int v) {
            return query(v + 1, n, 1, n, 1);
        }
    }
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[] A = new int[N];
            String[]input=read.readLine().trim().split(" ");
            for(int i=0;i<N;i++)
                A[i]=Integer.parseInt(input[i]);
            Solution ob=new Solution();
            int[]ans=ob.greaterLesser(A, N);
            for(int i=0;i<N;i++)
                out.print(ans[i]+" ");
            out.println("");

        }
        out.close();

    }
}

// } Driver Code Ends