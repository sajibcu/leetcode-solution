class Solution {
    public long coloredCells(int n) {
        // long ans = 1;
        // int interval = 0;
        // while( n > 1) {
        //    interval +=4;
        //    ans += interval;
        //    n--;
        // }
        // return ans;
        return 1 + (long) n * (n-1) * 2;
    }
}