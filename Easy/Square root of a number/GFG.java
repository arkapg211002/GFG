// https://www.geeksforgeeks.org/problems/square-root/1

//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        long left=0,right=n;
        while(left<=right){
            long mid=left+(right-left)/2;
            long pro=mid*mid;
            if(pro==n){
                return mid;
            }
            else if(pro>n){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return right;
    }
}
