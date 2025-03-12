class Solution {
    public int maximumCount(int[] nums) {

        int l = 0, r = nums.length -1 ;
        int mid = 0;

        while( l < r) {
            mid = (l + r) / 2;
            if( nums[mid] < 0 ) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        
        r = l;
        while( r < nums.length && nums[r] == 0 ){
            r++;
        }
        if( nums[l] < 0) l++;
        
        return Math.max(l, nums.length - r );
        
    }
}