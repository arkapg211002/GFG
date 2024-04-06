https://www.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter1322/1

```java
class Solution {
    Long countWays(int n) {
        if(n == 1) return (long)1;
        long result = n/2;
        return result+1;
    }
}
```
