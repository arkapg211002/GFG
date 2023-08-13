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
        PrintWriter out=new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int n1,int n2,int n3, int[] s1, int[] s2, int[] s3) {
        // code here
        int sa1=Arrays.stream(s1).sum();
        int sa2=Arrays.stream(s2).sum();
        int sa3=Arrays.stream(s3).sum();
        if(sa1==sa2 && sa2==sa3) return sa1;
        int min=(int)Math.min(sa1,(int)Math.min(sa2,sa3));
        int i=0,j=0,k=0;
        while(i<n1 && j<n2 && k<n3)
        {
            if(sa1>min) sa1-=s1[i++];
            if(sa2>min) sa2-=s2[j++];
            if(sa3>min) sa3-=s3[k++];
            if(sa1==sa2 && sa2==sa3) return sa1;
            min=(int)Math.min(sa1,(int)Math.min(sa2,sa3));
        }
        return 0;
    }
}
        
