//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // code here.
       int n = cardPoints.length ; 
       int sum = 0 ; int ans = 0 ;
       int window = 0 ; 
       // sorting the total value of the array 
       for(int i = 0 ; i< n ; i++){
           sum += cardPoints[i];
       }
       // if the length is equal to k then return sum ; 
       if(n == k) return sum ; 
       // now add the 3 element in the window
       
       for(int i = 0 ; i< n-k-1 ; i++){
           window += cardPoints[i];
       } 
       
       // now add the rest element int window and removing the smallest 
       // element in the array 
       
       for(int i = n-k-1 ; i < n ; i++){
           window += cardPoints[i]; // add the element from 3 index 
           ans = Math.max( ans , sum-window); // 22 - 10 ; 
           window -= cardPoints[i-(n-k-1)]; // and remove the element from  // from one index 
       }
       
       return ans ; 
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            int[] cardPoints = new int[inputArray.length];
            for (int j = 0; j < inputArray.length; j++) {
                cardPoints[j] = Integer.parseInt(inputArray[j]);
            }
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Solution solution = new Solution();
            System.out.println(solution.maxScore(cardPoints, k));
            System.out.println("~");
        }

        scanner.close();
    }
}

// } Driver Code Ends