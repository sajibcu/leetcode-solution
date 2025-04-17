class Solution {
    public int countPairs(int[] nums, int k) {

        Map<Integer,List<Integer>> mp = new HashMap<>();

        int ans = 0;
        for(int i =0; i< nums.length; i++) {
            mp.computeIfAbsent(nums[i], v -> new ArrayList<>());
            mp.get(nums[i]).add(i);
        }

        for(List<Integer> v: mp.values() ) {
            int size = v.size();
            if( size < 2) continue;
            for(int i = 0; i< size; i++) {
                for(int j=i+1;j<size; j++) {
                    if( (v.get(i) * v.get(j) ) % k == 0 ) ans++;
                }
            }
        }

        return ans;
        
    }
}