//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] arr = new int[n][2];
            int j = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(s[j]);
                j++;
                arr[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        List<int[]> res = new ArrayList<>();
        int s = -1;int e = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]<=e){
                e = Math.max(arr[i][1],e);
            }
            else{
                int[] add = new int[2];
                add[0] = s;
                add[1] = e;
                s = arr[i][0];
                e = arr[i][1];
                res.add(add);
            }
        }
        int[] add = new int[2];
        add[0] = s;
        add[1] = e;
        res.add(add);
        res.remove(0);
        return res;
    }
}

