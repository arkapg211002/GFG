//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int[] smallestSubsegment(int arr[]) {
        // Complete the function
        Map<Integer,Integer>count = new HashMap<>();
        Map<Integer,Integer>left = new HashMap<>();
        int maxi = 0;
        int startIndex = 0;
        int len = 0;
        for(int i=0;i<arr.length;i++){
            count.put(arr[i],count.getOrDefault(arr[i],0)+1);
            left.putIfAbsent(arr[i],i);
            if(count.get(arr[i])>maxi){
                maxi = count.get(arr[i]);
                len = i-left.get(arr[i])+1;
                startIndex = left.get(arr[i]);
            }else if(count.get(arr[i])==maxi && (i-left.get(arr[i])+1)<len){
                len = i-left.get(arr[i])+1;
                startIndex = left.get(arr[i]);
            }
        }
        int[] ans = new int[len];
        for(int i=startIndex;i<startIndex+len;i++){
            ans[i-startIndex] = arr[i];
        }
        return ans;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int answer[] = obj.smallestSubsegment(arr);
            int sz = answer.length;

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < sz; i++) output.append(answer[i] + " ");
            System.out.println(output);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends