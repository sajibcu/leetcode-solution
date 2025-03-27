class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer> mp = new HashMap<>();

        int dominant = 0;
        int max = 0;
        for(int n: nums) {
            int cnt =  mp.getOrDefault(n,0)+1;
            mp.put(n,cnt);
            if( cnt > max) {
                dominant = n;
                max = cnt;
            }
        }

        int left = 0,right = max;

        for( int i=0; i< nums.size(); i++) {
            int n = nums.get(i);
            if( n == dominant ){
                left++;
                right--;
                if( left > (i+1)/2 && right > (nums.size()-i-1)/2 ) return i;
            } 
            
        }

        return -1;
    }
}