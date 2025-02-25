class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1,prefixSum = 0;
        int mod = 1000000007;
        int ans = 0;

        for(int n: arr) {
            prefixSum +=n;

            if(prefixSum%2 == 0) {
                ans +=oddCount;
                evenCount++;
            }else {
                ans+=evenCount;
                oddCount++;
            }
            
            ans %=mod;
        }

        return ans;
        
    }
}