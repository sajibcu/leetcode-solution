class Solution {
    int maxOr;
    Integer[][] mem;
    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        for(int n: nums) maxOr |=n;
        mem = new Integer[nums.length][maxOr+1];
        return help(nums,0,0);
    }

    public int help(int[] nums, int index, int Or) {
        if( index == nums.length ) return maxOr == Or ? 1: 0;
        if( mem[index][Or] != null) return mem[index][Or];

        mem[index][Or] = help(nums,index+1, Or) +  help(nums,index+1,nums[index] | Or);
        return mem[index][Or];
    }
}