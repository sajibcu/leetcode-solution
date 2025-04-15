class Solution {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE, sum = 0;

        for( int i = 0; i< nums.length;i++) {
            sum = sum + nums[i];
            if( nums[i] > sum) {
                sum = nums[i];
            }
            if( sum > max) {
                max = sum;
            }
        }

        return max;
        
    }
}