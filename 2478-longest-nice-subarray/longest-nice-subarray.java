class Solution {
    public int longestNiceSubarray(int[] nums) {
        int[] bit = new int[32];

        int ans = 0;

        for( int i =0; i< nums.length; i++ ) {

            int j = i;
            clearBit(bit);
            while( j< nums.length && setBit(bit, nums[j]) == 0 ) {
                j++;
            }
            ans = Math.max(ans, j-i);

            // for(int a: bit) System.out.print(a+",");
            // System.out.println();
        }

        return ans;
    }

    public int setBit(int[] bit, int n ) {
        int i = 0;

        while( i < 32 ) {
            if( ( n & (1<<i) ) != 0  ) {
                if (bit[i] == 1) {
                    return 1;  // Bit already set
                } else {
                    bit[i] = 1;  // Mark bit position as set
                }
            }
            i++;
        }
        return 0;
    }

     public void clearBit(int[] bit) {
        for (int i = 0; i < 32; i++) {
            bit[i] = 0;
        }
    }
}