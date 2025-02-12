class Solution {
    public int maximumSum(int[] nums) {
    
        Map<Integer,int[]> originalNumber  = new HashMap<>();

        int maxSum = -1;

        for(int n: nums) {
            int sum = getDigitSum(n);
            originalNumber.putIfAbsent(sum, new int[]{-1, -1});
            int[] original = originalNumber.get(sum);
            if(original[0] < n ){
                original[1] = original[0];
                original[0] = n;
            }else if( original[1] < n )
                original[1] = n;

            if(original[1] > -1)
                maxSum = Math.max(maxSum, original[0] + original[1]);
        }

        return maxSum;
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