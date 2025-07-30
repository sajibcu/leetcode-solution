class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for( int n : nums) max = Math.max(max, n);
        
        int ans = 1;
        int temp = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != max) continue;

            if( nums[i] == nums[i-1]) {
                temp ++;
            }else temp = 1;

            ans = Math.max(ans, temp);
        }

        return ans;
    }
}