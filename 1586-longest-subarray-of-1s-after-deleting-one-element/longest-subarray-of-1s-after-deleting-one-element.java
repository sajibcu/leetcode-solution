class Solution {
    public int longestSubarray(int[] nums) {
        int zero = 0,one = 0;
        int start = 0;
        int longest = 0;
        for(int i=0;i<nums.length; i++) {
            if(nums[i]==1) one++;
            else zero++;
            if(zero > 1) {
                while(zero > 1 && nums[start] == 1 ) {
                    one--;
                    start++;
                }
                zero--;
                start++;
            }

            longest = Math.max(longest, zero == 0 ? one-1: one);          
        }
        
        return longest;
    }
}