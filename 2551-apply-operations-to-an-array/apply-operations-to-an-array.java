class Solution {
    public int[] applyOperations(int[] nums) {

        int l = nums.length;
        for(int i = 0; i< l -1 ; i++) {
            if( nums[i] == nums[i+1] ) {
                nums[i] = nums[i] << 1;
                nums[i+1] = 0;
                i++;
            }
        }
        
        int index=0;
        for(int i = 0; i< nums.length ; i++) {
            if( nums[i] != 0 ) {
                nums[index++] = nums[i];
            }
        }
        while( index < l) {
            nums[index++] =0;
        }

        return nums;
    }
}