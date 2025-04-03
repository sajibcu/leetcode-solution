class Solution {
    public long maximumTripletValue(int[] nums) {
        int l = nums.length;
        int[] prefixMax = new int[l];
        int[] sufixMax = new int[l];

        prefixMax[0] = nums[0];
        for(int i=1; i< l;i++) prefixMax[i] = Math.max(nums[i], prefixMax[i-1]);

        sufixMax[l-1] = nums[l-1];
        for(int i=l-2; i > -1 ;i--) sufixMax[i] = Math.max(nums[i], sufixMax[i+1]);

        long ans = 0;

        for( int i = 1; i< l-1; i++ ) {
            // System.out.println(prefixMax[i-1]+"$$"+sufixMax[i+1]);
            ans = Math.max(ans,(long) (prefixMax[i-1] - nums[i] ) * sufixMax[i+1] );
        }
        
        return ans;
    }
}