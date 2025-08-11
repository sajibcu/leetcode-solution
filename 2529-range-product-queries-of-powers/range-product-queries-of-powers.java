class Solution {
    private static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> power2 = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                power2.add(rep);
            }
            n /= 2;
            rep *= 2;
        }

        int[] ans = new int[queries.length];
        int i=0;
        for(int[] q: queries ) {
            long prod = 1;
            for(int j=q[0];j<=Math.min(q[1],power2.size() -1) ; j++) {
                prod = (prod * power2.get(j) ) % MOD;
            }
            ans[i++] = (int)prod;
        }
        return ans;
        
    }
}