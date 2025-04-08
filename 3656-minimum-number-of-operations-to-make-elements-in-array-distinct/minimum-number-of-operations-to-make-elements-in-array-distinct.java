class Solution {
    public int minimumOperations(int[] nums) {

        int[] freq = new int[101];
        for( int n: nums) freq[n]++;
        int i =0;
        int l = nums.length;
        int cnt = 0;
        if( isDistinct(freq) ) return cnt;
        while( i < l) {
            cnt++;
            if( i < l ) freq[nums[i++]]--;
            if( i < l ) freq[nums[i++]]--;
            if( i < l ) freq[nums[i++]]--;
            if( isDistinct(freq) ) return cnt;
        }

        return cnt;
        
    }

    public boolean isDistinct(int[] freq) {
        for(int i=1;i<=100;i++) if(freq[i] > 1) return false;
        return true;
    }
}