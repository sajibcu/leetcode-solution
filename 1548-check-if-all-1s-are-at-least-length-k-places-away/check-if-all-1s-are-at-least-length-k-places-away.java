class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int distance = k;

        for(int n : nums) {
            if( n ==1 ) {
                if( distance < k) return false;
                distance = 0; 
            }else distance++;
        }

        return true;
        
    }
}