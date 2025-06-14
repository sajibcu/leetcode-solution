class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        int len = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<len; i++) {
            mp.put(nums[i],i);
        }

        for(int i = 0; i < len; i++){
            int a = nums[i];

            for(int j=i+1;j<len;j++) {
                int b = nums[j]; 

                for(int k = j+1; k< len ; k++ ) {
                    int c = nums[k]; 
                    long remaining = (long)target - (long)a- (long)b-(long)c;

                    if( remaining >= Integer.MIN_VALUE && remaining <= Integer.MAX_VALUE  &&
                         mp.get((int)remaining) != null && mp.get((int)remaining) > k ) {
                        ans.add(List.of(a,b,c,(int)remaining));
                    }
                }

            }
        }
        return ans.stream().toList();
    }
}