//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            int[] start = new int[N];
            int[] end = new int[N];
            
            for(int i=0; i<N; i++)
            {
                start[i] = Integer.parseInt(S1[i]);
                end[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxEvents(start,end,N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends






//User function Template for Java

class Solution {
    static class Pair{
        int s;
        int e;
        Pair(int a,int b){
            s=a;
            e=b;
        }
    }
    static int maxEvents(int[] arr, int[] dep, int N) {
        
        ArrayList<Pair> list=new ArrayList<>(); 
        for(int i=0;i<arr.length;i++){
            list.add(new Pair(arr[i],dep[i]));
        }
        
        
        Collections.sort(list,(a,b)->a.s-b.s);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int day=list.get(0).s;
        
        int i=0;
        int cnt=0;
        while(i<N || pq.size()!=0){
            
            while(i<N && list.get(i).s==day){
                pq.add(list.get(i).e);
                i++;
            }
            
            if(pq.size()>0 && pq.peek()>=day){
                
                cnt++;
                pq.poll();
            }
            
            while(!pq.isEmpty() && pq.peek()<=day){
                pq.poll();
                
            }
            day++;
        }
        
        
        return cnt;
   
    }
};