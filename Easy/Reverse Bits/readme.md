https://www.geeksforgeeks.org/problems/reverse-bits3556/1

```java
class Solution {
    static Long reversedBits(Long x) {
        // code here
        StringBuilder sb=new StringBuilder("");
        while(x>0)
        {
            sb.append((char)(x%2+48));
            x=x/2;
        }
        int n=32-sb.length();
        for(int i=0;i<n;i++)
            sb.append((char)(48));
        return Long.parseLong(sb.toString(),2);


    }
};
```
