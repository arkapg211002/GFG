https://www.geeksforgeeks.org/problems/convert-to-strictly-increasing-array3351/1

```java
class Solution
{
    public int min_operations(int []nums)
    {
        // Code here
        int[] dp= new int[nums.length];
        for(int i=0;i<nums.length;i++)dp[i]=1;
        
        dp[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            int totalNumInBtw=0;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i] && totalNumInBtw < nums[i]-nums[j] ){
                    dp[i]=dp[i]<(dp[j]+1)?dp[j]+1:dp[i];
                    if(dp[i]>max)max=dp[i];
                }
                totalNumInBtw++;
            }
            
        }
        return nums.length -max;
    }
}
```
