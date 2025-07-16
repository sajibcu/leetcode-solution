class Solution {
    public int maximumLength(int[] nums) {

        int max = Math.max(getAlternatingLength(nums,0),getAlternatingLength(nums,1));
        int even=0,odd=0;
        for(int n : nums) {
            if(n%2==0) even++;
            else odd++;
        }

        return Math.max(Math.max(even, odd),max);
        
    }

    private int getAlternatingLength(int[] nums, int startParity) {
        int count = 0;
        int expectedParity = startParity;
        for (int num : nums) {
            if (num % 2 == expectedParity) {
                count++;
                expectedParity ^= 1; // toggle
            }
        }
        return count;
    }
}