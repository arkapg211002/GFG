//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    // Function to find the most frequent word in an array of strings.
    public String mostFrequentWord(String arr[], int n)
    {
        // Map to store the frequency of each word
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        // Map to store the first occurrence of each word
        HashMap<String, Integer> firstOccurrenceMap = new HashMap<>();
        
        // Iterate through the array to populate frequency and first occurrence maps
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            
            // Update frequency map
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            
            // Record the first occurrence if it's not already recorded
            if (!firstOccurrenceMap.containsKey(word)) {
                firstOccurrenceMap.put(word, i);
            }
        }
        
        // Variables to store the result
        String result = "";
        int maxFrequency = 0;
        int lastIndex = -1;
        
        // Iterate through the array again to determine the most frequent word
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            int frequency = frequencyMap.get(word);
            int firstIndex = firstOccurrenceMap.get(word);
            
            // If the current word has a higher frequency or same frequency but later first occurrence
            if (frequency > maxFrequency || (frequency == maxFrequency && firstIndex > lastIndex)) {
                maxFrequency = frequency;
                result = word;
                lastIndex = firstIndex;
            }
        }
        
        // Return the most frequent word
        return result;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends