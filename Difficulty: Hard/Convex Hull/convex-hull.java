//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] points_list = new int[n][2];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                points_list[i][0] = Integer.parseInt(s[0]);
                points_list[i][1] = Integer.parseInt(s[1]);
            }
            Solution obj = new Solution();
            int[][] ans = obj.FindConvexHull(points_list);
            if(ans.length == 1)System.out.println(ans[0][0]);
            else{
                for(int i = 0; i < ans.length; i++){
                    for(int j = 0; j < ans[i].length; j++)
                        System.out.print(ans[i][j] + " ");
                    System.out.println();
                }
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] FindConvexHull(int[][] points_list)
    {
        if(points_list.length<3){
            return new int[][]{{-1}};
        }
        int[] start=null;
        int minx=Integer.MAX_VALUE;
        int miny=Integer.MAX_VALUE;
        for(int[] point:points_list){
            if(point[0]<minx){
                start=point;
                minx=point[0];
                miny=point[1];
            }else if(point[0]==minx&&point[1]<miny){
                start=point;
                miny=point[1];
            }
        }
        int[] current=start;
        int[] next=null;
        Set<int[]> points=new HashSet<>();
        points.add(current);
        List<int[]> lst=new ArrayList<>();
        while(true){
            next=points_list[0];
            for(int i=1;i<points_list.length;i++){
                int[] point=points_list[i];
                if(point==current){
                    continue;
                }
                int val=alignment(current,next,point);
                if(val>0){
                    next=point;
                    lst=new ArrayList<>();
                }else if(val==0){
                    if(distance(current,next,point)>=0){
                        lst.add(point); 
                    }else{
                        lst.add(next);
                        next=point;
                    }
                }
            }
            /*for(int[] p:lst){
                points.add(p);
            }*/
            lst=new ArrayList<>();
            if(points.contains(next)){
                break;
            }
            points.add(next);
            current=next;
        }
        int[][] result=new int[points.size()][2];
        int count=0;
        for(int[] point:points){
            result[count++]=point;
        }
        Arrays.sort(result,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        return result;
    }
    
    public int alignment(int[] p,int[] q,int[] r){
        long rqy=r[1]-q[1];
        long qpx=q[0]-p[0];
        long rqx=r[0]-q[0];
        long qpy=q[1]-p[1];
        long val=rqy*qpx-rqx*qpy;
        if(val==0){
            return 0;
        }
        return val>0?1:-1;
    }
    
    public int distance(int[] p,int[] q,int[] r){
        long pqx=q[0]-p[0];
        long pqy=q[1]-p[1];
        long prx=r[0]-p[0];
        long pry=r[1]-p[1];
        return Long.compare(pqx*pqx+pqy*pqy,prx*prx+pry*pry);
    }
}