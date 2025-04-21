class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int low = 0; 
        int high = 0;
        int temp  = 0;
        for( int n: differences ) {
            temp +=n;
            if( temp < low) low = temp;
            if( temp > high ) high = temp;
            if( high - low > upper - lower) return 0;
        }

        low = lower - low;
        high = upper - high;

        return Math.max(0,high-low+1);
    }
}