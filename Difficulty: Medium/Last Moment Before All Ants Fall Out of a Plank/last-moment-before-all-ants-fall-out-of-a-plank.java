//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.nextLine().trim());

        while (testCases-- > 0) {
            int n = Integer.parseInt(sc.nextLine().trim());

            // Read the left array
            String temp = sc.nextLine().trim();
            String[] leftInput = temp.split(" ");
            // System.out.println(temp+" "+leftInput.length);
            int left[];
            if (leftInput.length == 1 && leftInput[0].isEmpty()) {
                left = new int[0];
            } else {
                left = new int[leftInput.length];
                for (int i = 0; i < left.length; i++)
                    left[i] = Integer.parseInt(leftInput[i]);
            }
            // Read the right array

            temp = sc.nextLine().trim();
            String[] rightInput = temp.split(" ");
            // System.out.println(temp+" "+rightInput.length+" "+rightInput[0]);
            int right[];
            if (rightInput.length == 1 && rightInput[0].isEmpty()) {
                right = new int[0];
            } else {
                right = new int[rightInput.length];
                for (int i = 0; i < right.length; i++)
                    right[i] = Integer.parseInt(rightInput[i]);
            }
            // Solution instance to invoke the function
            Solution sol = new Solution();
            int lastMoment = sol.getLastMoment(n, left, right);
            System.out.println(lastMoment);
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int sum=0;
        for(int x:left){
            sum=Math.max(sum,x);
        }
        for(int x:right){
            sum=Math.max(sum,n-x);
        }
        if(sum>n)
        sum=0;
        return sum;
    }
}