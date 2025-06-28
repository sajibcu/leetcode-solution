class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        boolean[] isTake = new boolean[nums.length];
        PriorityQueue<Node> nodes = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i = 0;i< nums.length; i++) {
            Node n = new Node(nums[i],i);
            nodes.add(n);
            if(nodes.size() > k ) nodes.poll();
        }

        List<Node> topK = new ArrayList<>(nodes);
        topK.sort(Comparator.comparingInt(n -> n.index));

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = topK.get(i).val;
        }

        return ans;
        
    }

}
class Node {
    int val;
    int index;
    Node(int val,int index) {
        this.val = val;
        this.index = index;
    }
}