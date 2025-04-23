class Solution {
    int[] dp = new int[10000];

    public int countLargestGroup(int n) {
        int[] freq = new int[37];
        while( n > 0) {
            freq[getDigitSum(n--)]++;
        }
        int ans = 0;
        int mx = 0;
        for( int a: freq)  {
            if( a > ans) {
                ans = a;
                mx = 1;
            }else if( a == ans) mx++; 
        }
        return mx;
    }

    public int getDigitSum(int n) {
        if( dp[n] != 0) return dp[n];
        if( n < 10) return dp[n] = n;
        return dp[n] = getDigitSum(n/10) + n%10;
    }
}