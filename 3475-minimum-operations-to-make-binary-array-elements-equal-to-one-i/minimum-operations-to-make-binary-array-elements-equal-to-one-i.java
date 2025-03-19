class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int l = nums.length;
        for(int i=0;i<l - 2;i++){
            if( nums[i] == 0 ) {
                ans++;
                nums[i] ^=1;
                nums[i+1] ^= 1;
                nums[i+2] ^= 1;
            }
        }

        if( nums[l-1] == 0 || nums[l-2] == 0 ) return -1;
        return ans;
    }
}