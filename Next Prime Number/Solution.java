// User function Template for Java
class Solution {
    public static int nextPrime(int n) {

        int count = 0;
        int num = 0;
        int end = Integer.MAX_VALUE;
        for(int i = n+1; i <= end; i++)
        {
             count = 0;
            for(int j = 1; j <= i; j++)
            {
                 if(i % j == 0)
                     count++;
            }
            if(count == 2 )
            {
                 num = i;
                 break;
            }
    }
    return num;
}
}
