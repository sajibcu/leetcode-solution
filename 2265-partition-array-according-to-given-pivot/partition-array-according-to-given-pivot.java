class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int index = 0;
        int[] ans = new int[nums.length];

        for(int n: nums ) {
            if( n < pivot ) ans[index++] = n;
        }
        for(int n: nums ) {
            if( n == pivot ) ans[index++] = n;
        }

        for(int n: nums ) {
            if( n > pivot ) ans[index++] = n;
        }

        return ans;
    }
}