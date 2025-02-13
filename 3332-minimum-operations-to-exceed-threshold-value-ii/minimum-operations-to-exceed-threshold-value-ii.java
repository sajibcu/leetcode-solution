class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int n: nums) {
            pq.add((long)n);
        }

        int op = 0;
        while( pq.peek() < k ) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add((long)((a<<1)+b));
            op++;
        }

        return op;
    }
}