https://www.geeksforgeeks.org/problems/rohans-love-for-matrix4723/1

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
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int firstElement(int n) {
        // code here
        if(n==1 || n==2) return 1;
        if(n==3) return 2;
        int a1=1, a2=2,a3=0;
        int i=4;
        while(i<=n){
            a3=(a1+a2)%1000000007;
            a1=a2;
            a2=a3%1000000007;
            i++;
        }
        return a3%(1000000007);
    }
}
```
