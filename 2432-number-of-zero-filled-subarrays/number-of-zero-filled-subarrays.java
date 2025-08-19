class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0L;
        long zeroCount = 0;
        for( int i=0;i<nums.length;i++ ){
            if( nums[i]==0 ){
                zeroCount++;
                continue;
            }
            else if( zeroCount > 0 ) {
                count +=getSubArrayCount( zeroCount );
                zeroCount = 0;
            } 
        }
        count +=getSubArrayCount( zeroCount );
        
        return count;
        
    }
    
    public long getSubArrayCount( long noOfZero ){
        return noOfZero*(noOfZero+1)/2;
    }
}