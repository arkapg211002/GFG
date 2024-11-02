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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    
    public static int util(int ar[], int start, int n, int len, int visited[]){
        if(start >= n || start < 0)
            return len;
        if(visited[start] == -2 || visited[start] == 0)
            return 0;
        if(visited[start] != -1)
            return len;
        
        visited[start] = -2;
        int res = util(ar, start+ar[start], n, len+1, visited);
        visited[start] = res;
        
        return res;
    }
    
    public static int goodStones(int n, int[] arr) {
        int visited[] = new int[n];
        Arrays.fill(visited, -1);
        int sum = 0;
        for(int i=0; i<n; i++){
            if(visited[i] == -1){
                int res = util(arr, i, n, 0, visited);
                sum += res;
            }
        }
        return sum;
    }
}
          
