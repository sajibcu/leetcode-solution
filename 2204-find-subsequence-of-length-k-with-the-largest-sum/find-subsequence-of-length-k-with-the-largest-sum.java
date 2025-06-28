class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        boolean[] isTake = new boolean[nums.length];
        PriorityQueue<Node> nodes = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i = 0;i< nums.length; i++) {
            Node n = new Node(nums[i],i);
            nodes.add(n);
            if(nodes.size() > k ) nodes.poll();
        }
        while(!nodes.isEmpty() ) {
            Node n = nodes.poll();
            isTake[n.index] = true;
        }
        int[] ans = new int[k];
        int l =0;

        for(int i=0;i<nums.length; i++) {
            if( isTake[i] == true ) {
                ans[l++] = nums[i];
            }
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