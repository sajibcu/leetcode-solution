class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] result = new int[nums.length];
        int[] bitIndex = new int[32];

        for(int i= nums.length-1; i>=0;i--) {
            int n = nums[i];

            for(int b=0;b<32;b++) {
                if((n & (1<<b)) != 0) {
                    bitIndex[b] = i;
                }
            }

            int maxIndex = i;
            for(int b=0;b<32;b++) {
                maxIndex = Math.max(maxIndex, bitIndex[b]);
            }

            result[i] = maxIndex-i+1;
        }

        return result;
        
    }
}