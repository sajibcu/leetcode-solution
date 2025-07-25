class Solution {

    public int maxSum(int[] nums) {
        boolean[] positive = new boolean[101];
        int max = -100;
        for (int num : nums) {
            if (num > 0) {
                positive[num] = true;
            }
            max = Math.max(max,num);
        }
        int sum = 0;
        for(int i =0; i< 101;i++) {
            if( positive[i] ) sum+=i;
        }
        return sum > 0 ? sum : max;
    }
}