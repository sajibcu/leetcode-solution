class Solution {
    public int maximumCandies(int[] candies, long k) {

        int r = 0;
        for(int n: candies ) {
            r = Math.max(n,r);
        }

        int l = 1,mid=0;
        int result = 0;

        while( l <= r) {
           mid = l + (r-l)/2;
           if( canMake( candies, mid ) >= k ) {
            result = mid;
            l = mid+1;
           }else {
                r = mid - 1;
           } 
        }
        return result;
    }

    public long canMake(int[] candies, int n) {
        long make = 0l;
        for( int candy : candies ) {
            make +=candy/n;
        }

        return make; 
    }
}