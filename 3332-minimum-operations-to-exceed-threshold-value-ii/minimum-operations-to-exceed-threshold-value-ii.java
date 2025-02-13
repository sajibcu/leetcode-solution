class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int n: nums) {
            pq.add((long)n);
        }

        int op = 0;
        while( pq.size()> 1 ) {
            long a = pq.poll();
            long b = pq.poll();
            if( a >= k ) break;
            pq.add((long)(a*2+b));
            op++;
        }

        return op;
    }
}