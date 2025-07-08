class Solution {
    Integer[][] dp;
    int[][] evnt;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b)-> a[0] - b[0]);
        evnt = events;
        dp = new Integer[evnt.length][k+1];
        return dfs(0,k);
    }
    public int dfs(int i, int k) {
        if(i==evnt.length || k == 0) return 0;
        if( dp[i][k] != null) return dp[i][k];
        int skip = dfs(i+1, k);
        int nextIndex = findNext(i,evnt[i][1]);
        int take = evnt[i][2] + dfs(nextIndex, k-1);
        return dp[i][k] = Math.max(skip, take);
    }
    public int findNext(int i, int end ) {
        int l = i,r=evnt.length;
        while( l < r) {
            int mid = l + (r-l)/2;
            if(evnt[mid][0] > end) {
                r = mid;
            }else {
                l = mid +1;
            }
        }

        return l;
    }
}