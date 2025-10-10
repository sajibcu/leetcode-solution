class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int ans = -10000000;

        for(int i=n-1; i>=0;i--) {
            if( i + k < n ) {
                dp[i] = energy[i] + dp[i+k];
            }else dp[i] = energy[i];

            ans = Math.max(dp[i], ans);
        }

        return ans;
        
    }
}