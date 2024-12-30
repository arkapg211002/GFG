//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
        	int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            System.out.println(ob.RulingPair(array,n));
            t--;
        
System.out.println("~");
}
    } 
} 
      
// } Driver Code Ends



//User function Template for Java
class Solution { 
	static int RulingPair(int arr[], int n) { 
        // Your code goes here
        Map<Integer, Integer> digitSumMap = new HashMap<>();
        int maxCombinedAbility = -1;
        for (int num : arr) {
            int digitSum = getDigitSum(num);
            if (digitSumMap.containsKey(digitSum)) {
                maxCombinedAbility = Math.max(maxCombinedAbility, digitSumMap.get(digitSum) + num);
            }
            digitSumMap.put(digitSum, Math.max(digitSumMap.getOrDefault(digitSum, 0), num));
        }

        return maxCombinedAbility;
    }
    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
	}    
} 