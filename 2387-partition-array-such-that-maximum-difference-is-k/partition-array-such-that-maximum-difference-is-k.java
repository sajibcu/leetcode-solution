class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
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