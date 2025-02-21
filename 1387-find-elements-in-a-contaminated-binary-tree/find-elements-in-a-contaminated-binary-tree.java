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
    TreeNode root;
    Map<Integer,Boolean> map;

    public void dfs(TreeNode root) {
        if( root.left != null) {
            root.left.val = (root.val << 1) + 1;
            map.put(root.left.val,true);
            dfs(root.left);
        }

        if( root.right != null) {
            root.right.val = (root.val << 1) + 2;
            map.put(root.right.val,true);
            dfs(root.right);
        }

    }

    public FindElements(TreeNode root) {
        root.val = 0;
        map = new HashMap<>();
        map.put(0,true);
        dfs(root);
        this.root = root;
    }
    
    public boolean find(int target) {
        return map.containsKey(target);
        //return findDFS(root, target);
        
    }

    public boolean findDFS(TreeNode root,int t) {
        if(root == null  ) return false;
        if( root.val==t ) return true;
        return findDFS(root.left,t) || findDFS(root.right,t);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */