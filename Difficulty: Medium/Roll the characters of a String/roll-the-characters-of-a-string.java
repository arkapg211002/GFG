//{ Driver Code Starts
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        Solution ob = new Solution();
        while (t-- > 0) {
            String s = scanner.nextLine();
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            List<Integer> roll = new ArrayList<>();
            for (String part : parts) {
                roll.add(Integer.parseInt(part));
            }
            String result = ob.findRollOut(s, roll);
            System.out.println(result);
        }
        scanner.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    // Function to find the new string obtained by rolling out characters.
    public String findRollOut(String s, List<Integer> roll) {
        // code here
        
        int size = s.length();
        int a[] = new int[size];
        int b[] = new int[size];
        
        for (int i=0; i<roll.size(); i++) {
            int idx = roll.get(i) - 1;
            a[idx] ++;
        }
        
        int prev = 0;
        for (int i=size-1; i>=0; i--) {
            b[i] = a[i] + prev;
            prev = b[i];
        }
        
        StringBuilder st = new StringBuilder();
        
        for (int i=0; i<size; i++) {
            char c = s.charAt(i);
            char newCh = (char) ('a' + (((c - 'a') + b[i]) % 26));
            st.append(newCh);
        }
        
        return st.toString();
    }
}