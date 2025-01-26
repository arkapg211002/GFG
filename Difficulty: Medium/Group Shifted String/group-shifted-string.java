//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String input = sc.nextLine();
            String[] arr = input.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.groupShiftedString(arr);

            for (ArrayList<String> group : result) {
                Collections.sort(group); // Sort each group lexicographically
            }
            result.sort(Comparator.comparing(
                list -> list.get(0))); // Sort groups lexicographically

            for (ArrayList<String> group : result) {
                for (String str : group) {
                    System.out.print(str + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends










class Solution {
    public ArrayList<ArrayList<String>> groupShiftedString(String[] arr) {
        // HashMap to store the groups of shifted strings
        HashMap<String, ArrayList<String>> groups = new HashMap<>();
        
        // Iterate over each string in the input array
        for (String s : arr) {
            // Get the shift pattern for the current string
            String pattern = getShiftPattern(s);
            
            // If the pattern doesn't exist in the map, create a new list
            if (!groups.containsKey(pattern)) {
                groups.put(pattern, new ArrayList<>());
            }
            
            // Add the current string to the list of the corresponding pattern
            groups.get(pattern).add(s);
        }
        
        // Prepare the result as a list of lists
        return new ArrayList<>(groups.values());
    }
    
    // Helper function to get the shift pattern of a string
    private String getShiftPattern(String s) {
        StringBuilder pattern = new StringBuilder();
        
        // Calculate the shift difference between each character and the first character
        for (int i = 1; i < s.length(); i++) {
            // Calculate the shift, modulo 26 to handle wrap-around (e.g., 'z' -> 'a')
            int shift = (s.charAt(i) - s.charAt(0) + 26) % 26;
            pattern.append(shift).append("#"); // Use '#' to separate the shifts
        }
        
        // Return the shift pattern as a string (we use "#" as a separator for shifts)
        return pattern.toString();
    }
}