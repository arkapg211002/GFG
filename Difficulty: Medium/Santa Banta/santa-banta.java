//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete {
    private static final int MAX_PRIME = 1000000;
    private static List<Integer> primes = new ArrayList<>();
    
    // Precompute the prime numbers using Sieve of Eratosthenes
    public static void precompute() {
        boolean[] isPrime = new boolean[MAX_PRIME + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime
        
        for (int i = 2; i * i <= MAX_PRIME; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX_PRIME; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= MAX_PRIME; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }
    
    // Function to find the maximum size of connected components
    public static int helpSanta(int n, int m, int g[][]) {
        if (m == 0) {
            return -1; // No connections
        }
        
        // Create an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill the graph with connections
        for (int i = 0; i < m; i++) {
            int u = g[i][0];
            int v = g[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n + 1];
        int maxGroupSize = 0;
        
        // Perform DFS to find all connected components
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int groupSize = dfs(graph, visited, i);
                maxGroupSize = Math.max(maxGroupSize, groupSize);
            }
        }
        
        // K is the size of the largest group
        int K = maxGroupSize;
        
        // Return the K-th prime number
        return K > 0 ? primes.get(K - 1) : -1;
    }
    
    // Helper method for DFS
    private static int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int size = 1;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(graph, visited, neighbor);
            }
        }
        
        return size;
    }
}