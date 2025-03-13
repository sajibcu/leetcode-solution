class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {

        int left = 0, right = queries.length, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZero(nums.clone(), queries, mid)) {
                result = mid;
                right = mid - 1; // Try to find a smaller k
            } else {
                left = mid + 1;
            }
        }
        
        return result;
        
    }

    private static boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        
        // Apply first k queries using a difference array
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] -= val;
            if (r + 1 < n) diff[r + 1] += val;
        }
        
        // Apply the difference array
        int decrement = 0;
        for (int i = 0; i < n; i++) {
            decrement += diff[i];
            nums[i] += decrement; // Apply accumulated decrement
            if (nums[i] > 0) return false; // If any element is still > 0, k is insufficient
        }
        
        return true; // Successfully made nums a Zero Array
    }
}