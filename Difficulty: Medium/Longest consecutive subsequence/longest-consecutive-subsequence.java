//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.findLongestConseqSubseq(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution
{   
    public int findLongestConseqSubseq(int arr[])
    {
        int n = arr.length;
        int smallValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        TreeMap<Integer,Integer>hm = new TreeMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],1);
            maxValue = Math.max(maxValue,arr[i]);
            smallValue = Math.min(smallValue,arr[i]);
        }
        int count = 0;
        int max = 0;
        for(int i=smallValue;i<maxValue+1;i++){
            if(hm.containsKey(i)){
                count++;
            }
            else{
                count = 0;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}