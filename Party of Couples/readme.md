https://www.geeksforgeeks.org/problems/alone-in-couple5507/1

```java
class Solution{
    static int findSingle(int n, int arr[]){
        // code here
        int ans = 0;
        for(int i = 0;i<n;i++) {
           ans = ans ^ arr[i]; 
        }
        return ans;
    }
}
```
