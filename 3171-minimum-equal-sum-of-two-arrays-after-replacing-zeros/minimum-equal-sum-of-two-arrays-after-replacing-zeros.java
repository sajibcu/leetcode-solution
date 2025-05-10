class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        for (int n : nums1) {
            if (n == 0) zero1++;
            sum1 += n;
        }

        for (int n : nums2) {
            if (n == 0) zero2++;
            sum2 += n;
        }

        // If both have no zero and sums are not equal, return -1
        if (zero1 == 0 && zero2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        }

        // If one has no zero, check if the sum with assumed 1s can match or exceed the other
        if (zero1 == 0 && sum1 < sum2 + zero2) return -1;
        if (zero2 == 0 && sum2 < sum1 + zero1) return -1;

        // Otherwise, return the max possible sum after replacing zeros with 1s
        return Math.max(sum1 + zero1, sum2 + zero2);
    }
}
