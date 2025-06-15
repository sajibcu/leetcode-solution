class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, (a,b)-> b-a);
        for( int n: nums) pq.add(n);
        int ans = 0;

        while(k--  > 0) {
            ans = pq.poll();
        }

        return ans;
    }
}