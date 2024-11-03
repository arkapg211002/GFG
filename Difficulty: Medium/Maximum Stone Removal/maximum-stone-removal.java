//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



class Solution {
    class DisjointSet{
        ArrayList<Integer> size= new ArrayList<>();
        ArrayList<Integer> parent= new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0; i<n; i++){
              size.add(1);
              parent.add(i);   
            }
        }
        public int getUPar(int node){
            if(parent.get(node)==node){
                return  node;
            }
            int uPar= getUPar(parent.get(node));
            parent.set(node,  uPar);
            return uPar;
        }
        public void unionBySize(int u, int v){
            int rootU= getUPar(u);
            int rootV= getUPar(v);
            if(rootU==rootV) return;
            if(size.get(rootU)> size.get(rootV)){
                parent.set(rootV, rootU);
                size.set(rootU, size.get(rootU)+size.get(rootV));
            }else{
                parent.set(rootU, rootV);
                size.set(rootV, size.get(rootV)+size.get(rootU));
            }
        }
    }
    public int maxRemove(int[][] stones, int n) {
        int maxRow = 0;
        int maxCol = 0;

        // Find the maximum row and column indices
        for (int[] arr : stones) {
            maxRow = Math.max(maxRow, arr[0]);
            maxCol = Math.max(maxCol, arr[1]);
        }

        // Initialize the Disjoint Set with a size to cover both rows and columns
        DisjointSet d = new DisjointSet(maxRow + maxCol + 2); // +2 for safety margin

        // HashSet to keep track of unique row and column nodes
        HashSet<Integer> hs = new HashSet<>();

        // Union the row and column of each stone
        for (int[] arr : stones) {
            int row = arr[0];
            int col = arr[1] + maxRow + 1; // Offset column index
            d.unionBySize(row, col);
            hs.add(row);
            hs.add(col);
        }

        // Count the number of unique connected components
        int count = 0;
        for (int num : hs) {
            if (d.getUPar(num) == num) {
                count++;
            }
        }

        // The maximum number of stones that can be removed
        return stones.length - count;
    }
};