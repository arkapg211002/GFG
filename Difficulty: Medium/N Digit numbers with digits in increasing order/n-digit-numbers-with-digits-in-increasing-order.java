//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.increasingNumbers(n);

            IntArray.print(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends





class Solution {
    private static ArrayList<Integer> ans;
    public static ArrayList<Integer> increasingNumbers(int n) {
        ans = new ArrayList<>();
        if (n == 1) {
            for (int i=0; i<=9; i++) {
                ans.add(i);
            }
            return ans;
        }
        
        backtrack(new ArrayList<>(), n);
        return ans;
    }
    
    static void backtrack(ArrayList<Integer> temp, int n) {
        if (n == 0) {
            int res = 0;
            for (int num: temp) {
                res = res * 10 + num;
            }
            ans.add(res);
            return;
        }
        
        int size = temp.size();
        int num = 0;
        // take from 1...9 if first elem, else take from next greater elem to 9
        if (size > 0) {
            num = temp.get(temp.size()-1);
        }
        for (int i=num+1; i<=9; i++) {
            temp.add(i);
            backtrack(temp, n-1);
            temp.remove(temp.size()-1);
        }
    }
}