class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int n: nums) {
            mp.put(n, mp.getOrDefault(n,0)+1);
        }

        int dominant = 0;
        int max = 0;
        for(int key : mp.keySet()) {
            if( mp.get(key) > max ) {
                dominant = key;
                max = mp.get(key);
            }
        }

        int left = 0;

        for( int i=0; i< nums.size(); i++) {
            int n = nums.get(i);
            if( n == dominant ) left++;
            int right = max - left;
            if( left > (i+1)/2 && right > (nums.size()-i-1)/2 ) return i;
        }

        return -1;
    }
}