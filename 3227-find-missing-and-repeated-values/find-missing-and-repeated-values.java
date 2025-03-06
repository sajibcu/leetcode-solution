class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] freq = new int[grid.length*grid.length+1];
        for ( int[] nums: grid ) {
            for( int n: nums) {
               freq[n]++; 
            }
        }

        int rep = 0, missing = 0;
        for(int i = 1;i<freq.length; i++) {
            if( freq[i] == 1) continue;
            if( freq[i]== 0 ) missing = i;
            else if( freq[i]== 2 ) rep= i;
        }

        return new int[]{rep,missing};
    }
}