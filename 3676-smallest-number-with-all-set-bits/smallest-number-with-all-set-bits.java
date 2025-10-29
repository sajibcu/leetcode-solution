class Solution {
    public int smallestNumber(int n) {
        int b = 0;
        int ans = 1;
        while( ans < n) {
            b++;
            ans +=(1<<b);
        }

        return ans;
        
    }
}