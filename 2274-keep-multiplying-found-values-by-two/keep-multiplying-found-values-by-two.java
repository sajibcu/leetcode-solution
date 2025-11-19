class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] isExist = new boolean[1001];

        for( int n : nums) isExist[n] = true;

        while( original < 1001) {
            if( isExist[original]) original <<=1;
            else break;
        }

        return original;
        
    }
}