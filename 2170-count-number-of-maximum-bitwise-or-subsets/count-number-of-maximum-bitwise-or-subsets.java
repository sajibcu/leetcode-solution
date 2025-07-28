class Solution {
    int maxOr;
    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        for(int n: nums) maxOr |=n;

        return help(nums,0,0);
    }

    public int help(int[] nums, int index, int Or) {
        if( index == nums.length ) return maxOr == Or ? 1: 0;
        return help(nums,index+1, Or) +  help(nums,index+1,nums[index] | Or);
    }
}