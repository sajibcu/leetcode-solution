class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int prefixSum = 0;
        for(int i=0;i<nums.length; i++) {
            prefixSum =(prefixSum + nums[i]) % k;
            if( mp.containsKey(prefixSum) ) {
                if( i - mp.get(prefixSum) > 1 )
                    return true;
            } else 
                mp.put(prefixSum, i);
        }

        return false;
        
    }
}