class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);

        int currentSum = 0;

        int ans = 0;

        for(int i=0;i<nums.length; i++) {
            currentSum += nums[i];

            int rest = currentSum-k;
            if( mp.containsKey(rest)) ans +=mp.get(rest);
            mp.put(currentSum,mp.getOrDefault(currentSum,0) + 1);
        }

        return ans;
        
    }
}