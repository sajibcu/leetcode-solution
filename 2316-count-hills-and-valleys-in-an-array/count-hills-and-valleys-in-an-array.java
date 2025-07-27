class Solution {
    public int countHillValley(int[] nums) {

        int ans = 0;
        for(int i=1;i<nums.length;i++){
            int left = i;
            int right = i;
            if(nums[i] == nums[i-1]) continue;
            while(left > 0 && nums[i] == nums[left] ) left--;
            while(right < nums.length-1 && nums[i] == nums[right]) right++;
            if( nums[left] > nums[i] && nums[right] > nums[i]) ans++;
            if( nums[left] < nums[i] && nums[right] < nums[i]) ans++;
        
        }
        return ans;
        
    }
}