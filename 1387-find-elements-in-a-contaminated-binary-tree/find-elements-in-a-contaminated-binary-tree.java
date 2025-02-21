/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    private HashSet<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        root.val = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while( !st.isEmpty() ) {
            TreeNode node = st.pop();
            values.add(node.val);
            if (node.right != null) {
                node.right.val = (node.val << 1) + 2;
                st.push(node.right);
            }
            if (node.left != null) {
                node.left.val = (node.val << 1) + 1;
                st.push(node.left);
            }
        }
    }
    
    public boolean find(int target) {
        return values.contains(target);
        
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */