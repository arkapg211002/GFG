//{ Driver Code Starts
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        while (t-- > 0) {
            String line = scanner.nextLine(); // Read each line of input
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Create an array for input numbers

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(
                    elements[i]); // Populate the array with input numbers
            }

            Solution ob = new Solution();
            System.out.println(ob.countMinOperations(arr)); // Print the result
        }
        scanner.close(); // Close the scanner
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    // Method to count the minimum operations required
  
    int countMinOperations(int[] arr) {
          int res=0;
          while(true){
              int zero_count=0;
              int i;
              for(i=0;i<arr.length;i++){
                  if(arr[i]%2==1)
                  break;
                  if(arr[i]==0)
                  zero_count++;
              }
              if(zero_count==arr.length)
              return res;
              if(i==arr.length){
                  for(int j=0;j<arr.length;j++){
                      arr[j]=arr[j]/2;
                  }
                  res++;
              }
              for(int j=i;j<arr.length;j++){
                  if(arr[j]%2==1){
                      arr[j]=arr[j]-1;
                      res++;
                  }
              }
          }
    }
}