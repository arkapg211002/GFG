//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class pair{
    int first;
    int second;
    pair(int first,int second)
        {
            this.first = first;
            this.second = second;
        }
}
class GfG
{
    public static void main(String args[])throws IOException
        {
            
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , k;
                    n=sc.nextInt();
                    k=sc.nextInt();
                    ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
                    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                    for(int i = 0 ; i < n ; ++ i )
                    {
                        ArrayList<Integer> vec = new ArrayList<Integer>(2);
                        int x  = sc.nextInt();
                        int y = sc.nextInt();
                        vec.add(0,x);
                        vec.add(1,y);
                        p.add(vec);

                    }
                    Solution obj = new Solution();
                    res = obj.kClosest(p, k);
                
                    for(int i = 0 ; i < k ; ++ i )
                        System.out.print(res.get(i).get(0) + " " + res.get(i).get(1) + " " );
                    System.out.println();
    
                
System.out.println("~");
}
        }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    public static ArrayList<ArrayList<Integer>> kClosest(ArrayList<ArrayList<Integer>> points, int K)
    {
        //code here.
         // Priority queue (max-heap) to maintain K closest points
        PriorityQueue<ArrayList<Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a.get(0) * a.get(0) + a.get(1) * a.get(1);
            int distB = b.get(0) * b.get(0) + b.get(1) * b.get(1);

            // Primary sort by distance (descending for max-heap)
            if (distA != distB) {
                return Integer.compare(distB, distA);
            }
            // Secondary sort by x-coordinate
            if (!a.get(0).equals(b.get(0))) {
                return Integer.compare(b.get(0), a.get(0));
            }
            // Tertiary sort by y-coordinate
            return Integer.compare(b.get(1), a.get(1));
        });

        // Add points to the heap and maintain its size
        for (ArrayList<Integer> point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        // Extract K closest points from the heap
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        // Sort the result for the final output
        result.sort((a, b) -> {
            int distA = a.get(0) * a.get(0) + a.get(1) * a.get(1);
            int distB = b.get(0) * b.get(0) + b.get(1) * b.get(1);

            // Primary sort by distance (ascending for final result)
            if (distA != distB) {
                return Integer.compare(distA, distB);
            }
            // Secondary sort by x-coordinate
            if (!a.get(0).equals(b.get(0))) {
                return Integer.compare(a.get(0), b.get(0));
            }
            // Tertiary sort by y-coordinate
            return Integer.compare(a.get(1), b.get(1));
        });

        return result;
    }

}