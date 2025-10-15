class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int a = 0,b=1;

        for( int i =1;i<nums.size();i++) {
            if( nums.get(i-1) < nums.get(i)) {
                b++;
            }else {
                a = b;
                b =1;
            }
            //System.out.println(a+"&"+b);
            ans = Math.max( ans, Math.max(Math.min(a,b), b/2) );
        }
        return ans;
        
    }
}