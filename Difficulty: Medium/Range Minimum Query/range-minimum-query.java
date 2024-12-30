//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class GfG
{
    static int st[];
    public static void build(int i,int l,int r,int a[],int st[]){
        if(l==r){
            st[i]=a[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*i+1,l,mid,a,st);
        build(2*i+2,mid+1,r,a,st);
        st[i]=Math.min(st[2*i+1],st[2*i+2]);
    }
    public static int query(int i,int l,int r,int s,int e,int st[]){
        if(s>r || e<l){
            return Integer.MAX_VALUE;
        }
        if(l>=s && r<=e){
            return st[i];
        }
        int mid=l+(r-l)/2;
        return Math.min(query(2*i+1,l,mid,s,e,st),query(2*i+2,mid+1,r,s,e,st));
    }
    public static int[] constructST(int arr[], int n)
    {
        st = new int[4*n];

        build(0,0,n-1,arr,st);
        return st;
    }
    
    public static int RMQ(int st[], int n, int l, int r)
    {
        return query(0,0,n-1,l,r,st);
    }
    
    
}