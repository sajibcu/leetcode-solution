class Solution {
    public int subsetXORSum(int[] nums) {
        return help(nums, 0,0);
    }

    public int help(int[] nums, int index, int cur) {
        if( index == nums.length ) {
            return cur;
        }
        return help(nums, index+1,cur) + help(nums,index+1, cur^nums[index]);
    }
}