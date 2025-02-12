class Solution {
    public int maximumSum(int[] nums) {
        int[] frequencyOfDigitSum = new int[100];
        Map<Integer,Integer[]> originalNumber  = new HashMap<>();

        for(int n: nums) {
            int sum = getDigitSum(n);
            frequencyOfDigitSum[sum]++;
            Integer[] original = originalNumber.get(sum);
            if(original == null) {
                original = new Integer[2];
            }
            setOriginal(original,n);
            originalNumber.put(sum, original );
        }

        int maxSum = -1;

        for(int i=0;i<100;i++){
            if(frequencyOfDigitSum[i] > 1) {
                Integer[] original = originalNumber.get(i);
                maxSum = Math.max(maxSum, original[0] + original[1]);
            }
        }
        return maxSum;
    }
    public void setOriginal(Integer[] nums, int value) {
        if(nums[0] == null) {
            nums[0] = value;
            return;
        }

        if(nums[1] == null) {
            nums[1] = value;
            return;
        }

        if(nums[0] < value) {
            int temp = nums[0];
            nums[0] = value;
            if(nums[1] < temp )
            nums[1] = temp;
            return;
        }

        if( nums[1]< value)
        nums[1] = value;
    }


    public int getDigitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum +=num%10;
            num /=10;
        }
        return sum; 
    }
}