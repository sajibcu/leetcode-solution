class Solution {
    public int partitionArray(int[] nums, int k) {
        boolean sorted = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (!sorted) Arrays.sort(nums);
        int ans = 1;
        int l=0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(nums[i] - nums[l] <= k) continue;
            l=i;
            ans++;
        }
        return ans;
        
    }
}