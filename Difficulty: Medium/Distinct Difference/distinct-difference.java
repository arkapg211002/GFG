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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(Integer n: A){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        HashSet<Integer>left = new HashSet<>();
        
        ArrayList<Integer>result = new ArrayList<>();
        for(int i=0; i<N; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) - 1);
            if(map.get(A[i])==0)map.remove(A[i]);
           
            result.add(left.size() - map.size());
            
            left.add(A[i]);
        }
        
        return result;
        
    }
}
        