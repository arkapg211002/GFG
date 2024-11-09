//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine()); // Read the number of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine()); // Read the size of the array

            // Read array a
            String[] aInput = scanner.nextLine().split(" ");
            int[] a = new int[aInput.length];
            for (int i = 0; i < aInput.length; i++) {
                a[i] = Integer.parseInt(aInput[i]);
            }

            // Read array b
            String[] bInput = scanner.nextLine().split(" ");
            int[] b = new int[bInput.length];
            for (int i = 0; i < bInput.length; i++) {
                b[i] = Integer.parseInt(bInput[i]);
            }

            // Read array k
            String[] kInput = scanner.nextLine().split(" ");
            int[] k = new int[kInput.length];
            for (int i = 0; i < kInput.length; i++) {
                k[i] = Integer.parseInt(kInput[i]);
            }

            Solution solution = new Solution();
            System.out.println(solution.findMax(n, a, b, k));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // code here
        int[] arr =new int[n];
        
        for(int i=0;i<a.length;i++){
            int s=a[i];
            int e=b[i];
            int K=k[i];
            arr[s]= arr[s]+K;
            if(e+1<n) arr[e+1]= arr[e+1]-K;
        }
        
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            arr[i]=sum;
            max=Math.max(max,sum);
        }
        return max;
    }
}