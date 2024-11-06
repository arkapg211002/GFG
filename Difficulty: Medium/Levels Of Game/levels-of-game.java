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
            
            int[] a = IntArray.input(br, 2);
            int h = a[0],m = a[1];
            Solution obj = new Solution();
            int res = obj.maxLevel(h,m);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution {
    public static int maxLevel(int h,int m) {
        // code here
          int road_1=0,road_2=0,road_3=0;
            int count=0;
            while((road_1==0 && h>20) || (road_2==0 && h>5 && m>10) || (road_3==0))
            {
                if(road_3==0){
                      h+=3;
                    m+=2;
                     road_1=0;
                    road_2=0;
                    road_3=1;
                    count++;
                
                }
                if(h>5 && m>10 && road_2==0)
                {
                   
                     h-=5;
                    m-=10;
                     road_1=0;
                    road_2=1;
                    road_3=0;
                    count++;
                }
                else if(h>20 && road_1==0){
                    h-=20;
                    m+=5;
                    road_1=1;
                    road_2=0;
                    road_3=0;
                    count++;
                }
                
                else
                {
                    if(road_3==0){
                    h+=3;
                    m+=2;
                     road_1=0;
                    road_2=0;
                    road_3=1;
                    count++;
                    }
                    else{
                        break;
                    }
                }
            }
            return count;
    }
}
        