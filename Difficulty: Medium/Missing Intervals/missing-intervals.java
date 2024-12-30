//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    public List<int[]> missingIntervals(int[] arr, int l, int r) {
        // Your code here
        List<int[]> res = new ArrayList<>();
        int[] temp = new int[2];
        if(arr[0] > l){
            temp[0] = l;
            temp[1] = arr[0]-1;
            res.add(temp);
        }
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int[] temp1 = new int[2];
            if(arr[i+1]!=arr[i] && arr[i+1] != arr[i]+1){
                temp1[0] = arr[i]+1;
                temp1[1] = arr[i+1]-1;
                res.add(temp1);
            }
        }
        int[] temp2 = new int[2];
        if(arr[n-1] < r){
            temp2[0] = arr[n-1]+1;
            temp2[1] = r;
            res.add(temp2);
        }
        if(res.size()==0){
            res.add(new int[]{-1,-1});
        }
        return res;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Solution obj = new Solution();
            List<int[]> result = obj.missingIntervals(arr, l, r);
            for (int[] pr : result) {
                System.out.print("{" + pr[0] + " " + pr[1] + "} ");
            }
            System.out.println();
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends