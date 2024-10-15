//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String[] nums = StringArray.input(br, N);
            
            
            String target;
            target = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countPairs(N, nums, target);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution
{
    public static int countPairs(int N, String[] nums, String target)
    {
        HashMap<String, Integer> countMap = new HashMap<>();
        int totalCount = 0;
        
        // Populate the countMap with occurrences of each number in nums
        for (String num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Iterate over each number to find pairs
        for (String num : nums) {
            // Check if num can be a prefix
            if (target.startsWith(num)) {
                // Calculate the suffix needed to form target
                String suffix = target.substring(num.length());
                if (countMap.containsKey(suffix)) {
                    totalCount += countMap.get(suffix);
                    // If num and suffix are the same, we should subtract one
                    // to avoid counting the same element as both i and j
                    if (suffix.equals(num)) {
                        totalCount--;
                    }
                }
            }

            // Check if num can be a suffix
            if (target.endsWith(num)) {
                // Calculate the prefix needed to form target
                String prefix = target.substring(0, target.length() - num.length());
                if (countMap.containsKey(prefix)) {
                    totalCount += countMap.get(prefix);
                    // If num and prefix are the same, we should subtract one
                    // to avoid counting the same element as both i and j
                    if (prefix.equals(num)) {
                        totalCount--;
                    }
                }
            }
        }

        // Each pair (i, j) is counted twice, once as (i, j) and once as (j, i)
        return totalCount / 2;
    }

   
}
