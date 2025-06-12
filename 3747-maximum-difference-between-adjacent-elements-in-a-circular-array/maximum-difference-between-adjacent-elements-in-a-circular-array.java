class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int dif = Math.abs(nums[0] - nums[nums.length-1]);

        int maxDiff = IntStream.range(1, nums.length)
                .parallel()
                .map(i -> Math.abs(nums[i] - nums[i - 1]))
                .max()
                .orElse(0);

        return Math.max(dif,maxDiff);
        
    }
}