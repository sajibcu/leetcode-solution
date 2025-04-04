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
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {

         return dfs( root ).node;
        
    }

    public Result dfs( TreeNode node) {
        if( node == null ) return new Result( null, 0);
        Result l = dfs(node.left), r = dfs( node.right);

        if( l.dist > r.dist) return new Result(l.node, l.dist + 1);
        if( l.dist < r.dist) return new Result(r.node, r.dist+1);

        return new Result(node, l.dist+1);
    }
}

class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}