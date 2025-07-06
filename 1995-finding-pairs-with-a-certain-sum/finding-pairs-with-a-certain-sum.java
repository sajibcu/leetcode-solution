class FindSumPairs {
    int[] nums1;
    int[] nums2;

    Map<Integer,Integer> mp;
    Map<Integer,Integer> freq1;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        mp = new HashMap<>();
        freq1 = new HashMap<>();
        for( int n : nums2) {
            mp.put(n, mp.getOrDefault(n,0)+1);
        }

        for( int n : nums1) {
            freq1.put(n, freq1.getOrDefault(n,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int key = nums2[index];
        mp.put(key, mp.getOrDefault(key,0)-1);
        if (mp.get(key) == 0) mp.remove(key);

        mp.put(key+val, mp.getOrDefault(key+val,0)+1);
        nums2[index] +=val;

    }
    
    public int count(int tot) {
        int cnt = 0;
        for(int n: freq1.keySet()) {
            int remaining = tot - n;
            if(mp.containsKey(remaining)  ) {
                cnt +=freq1.get(n)*mp.get(remaining);
            }
        }

        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */