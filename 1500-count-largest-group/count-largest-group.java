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
            //System.out.println(a);
            if( a > ans) {
                ans = a;
                mx = 1;
            }else if( a == ans) mx++; 
        }
        return mx;
    }

    public int getDigitSum(int n) {
        int sum = 0;
        int original = n;
        while(n > 0) {
            if( dp[n] != 0 ) {
                sum +=dp[n];
                break;
            }
            sum +=n%10;
            n /=10;
        }
        dp[original] = sum;
        return sum;
    }
}