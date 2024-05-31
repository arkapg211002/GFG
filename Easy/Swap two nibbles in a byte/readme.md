// https://www.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1

```java
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int swapNibbles(int n) {
        // code here
        String bin = Integer.toBinaryString(n);
        while(bin.length() < 8) bin = "0"+bin;
        bin = bin.substring(4)+bin.substring(0,4);
        return Integer.parseInt(bin,2);
    }
}
```
