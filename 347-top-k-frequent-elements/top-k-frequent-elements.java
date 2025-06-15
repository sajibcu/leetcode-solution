class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> freq.get(b) - freq.get(a));
        for(int n: nums) freq.put(n,freq.getOrDefault(n,0)+1);
        for(int key: freq.keySet()) {
            pq.add(key);
        }

        int[] ans = new int[k];
        int i=0;
        while( i < k) {
            ans[i++] = pq.poll();
        }

        return ans;

    }
}