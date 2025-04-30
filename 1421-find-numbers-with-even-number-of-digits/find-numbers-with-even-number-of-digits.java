class Solution {
    public int findNumbers(int[] nums) {

        int cnt = 0;

        for(int n : nums) {
            if( n < 10 ) {
                
            }
            else if( n < 100 ) cnt ++;
            else if( n < 1000) {

            }
            else if( n < 10000) cnt ++;
            else if( n< 100000) {

            }
            else if( n < 1000000) cnt++;
        }
        return cnt;
    }
}