class Solution {
    public boolean checkPowersOfThree(int n) {
        int threePow = 4782969; // 3^14 = 4782969
        while( threePow > 0) {
            if( threePow <= n ) {
                n -=threePow;
            }

            threePow /=3;
        }
        return n == 0;  
    }
}