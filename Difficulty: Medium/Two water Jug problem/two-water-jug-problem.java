//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int d = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            int ans = ob.minSteps(m, n, d);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    // Class to represent state of both jugs
    static class State {
        int jug1;
        int jug2;
        int steps;
        
        State(int jug1, int jug2, int steps) {
            this.jug1 = jug1;
            this.jug2 = jug2;
            this.steps = steps;
        }
    }
    
    public int minSteps(int m, int n, int d) {
        // If target is greater than both jugs, impossible
        if (d > Math.max(m, n)) {
            return -1;
        }
        
        // If target cannot be achieved using GCD
        if (d % gcd(m, n) != 0) {
            return -1;
        }
        
        // Use HashSet to track visited states
        HashSet<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        
        // Start with empty jugs
        State initial = new State(0, 0, 0);
        queue.add(initial);
        visited.add("0,0");
        
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            
            // If target is achieved
            if (curr.jug1 == d || curr.jug2 == d) {
                return curr.steps;
            }
            
            // Try all possible operations
            
            // 1. Fill first jug
            addState(m, curr.jug2, curr.steps + 1, visited, queue);
            
            // 2. Fill second jug
            addState(curr.jug1, n, curr.steps + 1, visited, queue);
            
            // 3. Empty first jug
            addState(0, curr.jug2, curr.steps + 1, visited, queue);
            
            // 4. Empty second jug
            addState(curr.jug1, 0, curr.steps + 1, visited, queue);
            
            // 5. Pour from jug1 to jug2
            int pour1to2 = Math.min(curr.jug1, n - curr.jug2);
            addState(curr.jug1 - pour1to2, curr.jug2 + pour1to2, curr.steps + 1, visited, queue);
            
            // 6. Pour from jug2 to jug1
            int pour2to1 = Math.min(curr.jug2, m - curr.jug1);
            addState(curr.jug1 + pour2to1, curr.jug2 - pour2to1, curr.steps + 1, visited, queue);
        }
        
        return -1;
    }
    
    private void addState(int jug1, int jug2, int steps, HashSet<String> visited, Queue<State> queue) {
        String state = jug1 + "," + jug2;
        if (!visited.contains(state)) {
            queue.add(new State(jug1, jug2, steps));
            visited.add(state);
        }
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}