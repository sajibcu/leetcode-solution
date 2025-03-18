class Solution {
    public int longestNiceSubarray(int[] nums) {
    
        int ans = 0;

        for( int i =0; i< nums.length; i++ ) {

            int j = i;
            int mask = 0;
            while( j< nums.length && (mask & nums[j]) == 0 ) {
                mask |=nums[j];
                j++;
            }
            ans = Math.max(ans, j-i);
        }

        return ans;
    }
}