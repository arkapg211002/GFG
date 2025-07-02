// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check mid and its immediate neighbors
            if (arr[mid] == target) return mid;
            if (mid > low && arr[mid - 1] == target) return mid - 1;
            if (mid < high && arr[mid + 1] == target) return mid + 1;

            // Adjust search space by skipping already checked elements
            if (target < arr[mid]) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }

        // Element not found
        return -1;
    }
}
