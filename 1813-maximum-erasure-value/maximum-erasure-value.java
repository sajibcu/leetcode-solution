class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] freq = new int[10001];
        int start = 0;
        int max = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++) {
            if( freq[nums[i]] == 1 ) {
                while(start < i && nums[start] != nums[i]) {
                    temp -=nums[start];
                    freq[nums[start]]--;
                    start++;
                    
                }
                temp -=nums[start];
                freq[nums[start]]--;
                start++;
            }
            freq[nums[i]]++;
            temp +=nums[i];
            max = Math.max(temp,max);
        }

        return max;
    }
}