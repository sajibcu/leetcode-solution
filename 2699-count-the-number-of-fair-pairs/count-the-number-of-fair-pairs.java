class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);

        long ans = 0;

        for(int i = 0; i< nums.length; i++ ) {
            int n = nums[i];
            int l = lower - n;
            int r = upper - n;

            ans +=getUpper(nums,r,i+1) - getLowerIndex(nums, l,i+1);
        }

        return ans;
        
    }

    public int getUpper(int[] nums, int n,int start) {
        int l = start, r = nums.length-1;
        int mid;

        while(l <= r) {
             mid = l + (r-l)/2;
             if( nums[mid] <= n ) {
                l = mid+1;
             }else r = mid -1 ;
        }
        return l + (r-l)/2;
    }

    public int getLowerIndex(int[] nums, int n, int start) {
        int l = start, r = nums.length-1;
        int mid;

        while(l <= r) {
             mid = l + (r-l)/2;
             if(  nums[mid] < n) {
                l = mid +1;
             }else r = mid -1 ;
        }
        return l + (r-l)/2;
    }
}