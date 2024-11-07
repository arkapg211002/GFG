//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int arr[] = new int[elements.length]; // Correctly declared as int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.countDivisorsMult(arr));
        }
        scanner.close();
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    // Function to count divisors of the product of elements in the array
    public long countDivisorsMult(int[] arr) {
        Map<Integer, Integer> primeCount = new HashMap<>();

        // Factorization for each number in the array
        for (int num : arr) {
            Map<Integer, Integer> factors = primeFactorization(num);
            for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
                primeCount.put(entry.getKey(), primeCount.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        // Calculate the number of divisors using the prime counts
        long divisorCount = 1;
        for (int count : primeCount.values()) {
            divisorCount *= (count + 1);
        }

        return divisorCount;
    }

    // Helper function to perform prime factorization
    private Map<Integer, Integer> primeFactorization(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) { // If n is a prime number greater than 1
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }
        return factors;
    }
}