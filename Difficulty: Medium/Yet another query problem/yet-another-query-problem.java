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
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
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
            
            
            int num;
            num = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[][] Q = IntMatrix.input(br, num, 3);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.solveQueries(N, num, A, Q);
            
            IntArray.print(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends





class Solution {
    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int left = Q[i][0];
            int right = Q[i][1];
            int k = Q[i][2];
            int count = 0;
            for (int j = left; j <= right; j++) {
                int frequency = 0;
                for (int m = j; m < N; m++) {
                    if (A[m] == A[j]) {
                        frequency++;
                    }
                }
                if (frequency == k) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read N and num
        int N = sc.nextInt();
        int num = sc.nextInt();
        
        // Read array A
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // Read queries
        int[][] Q = new int[num][3];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                Q[i][j] = sc.nextInt();
            }
        }

        // Solve queries
        ArrayList<Integer> result = solveQueries(N, num, A, Q);
        
        // Print results
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}