class Solution {
    int maxValue(int[] arr) {
        // code here
        int[][] dp = new int[arr.length][2];
        for (int[] a : dp) {
            a[0] = a[1] = -1;
        }
        return maxValue(arr, dp, 0, 0);
    }
    
    private int maxValue(int[] arr, int[][] dp, int index, int firstRobbed) {
        if (index >= arr.length) {
            return 0;
        }
        if (dp[index][firstRobbed] != -1) {
            return dp[index][firstRobbed];
        }
        if (index == arr.length - 1) {
            return firstRobbed == 1 ? 0 : arr[index];
        }
        int rob;
        if (index == 0) {
            rob = Math.max(arr[index] + maxValue(arr, dp, index + 2, 1), maxValue(arr, dp, index + 1, 0));
        } else {
            rob = Math.max(arr[index] + maxValue(arr, dp, index + 2, firstRobbed), maxValue(arr, dp, index + 1, firstRobbed));
        }
        dp[index][firstRobbed] = rob;
        return rob;
    }
}
