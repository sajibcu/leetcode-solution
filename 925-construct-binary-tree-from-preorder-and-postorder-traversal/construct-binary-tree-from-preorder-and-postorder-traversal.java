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
    int[] preorder,postorder;
    int[] preeMp,postMp;
    
    public TreeNode constract(int l,int r) {
        if (l > r) return null;
        int val = preorder[l];
        TreeNode root = new TreeNode(val);
        
        if(l==r) {
            return root;
        }
        
        int postIndex = postMp[val] -1 ;
        if (postIndex < 0 ) return root;
       
        int preIndex = preeMp[postorder[postIndex]];
        root.left = constract(l+1, preIndex-1);
        root.right = constract(preIndex, r);
        return root;

    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        preeMp = new int[31];
        postMp = new int[31];
        for(int i =0;i<postorder.length; i++){
            preeMp[preorder[i]] = i;
            postMp[ postorder[i] ] = i;;
        }
       return constract(0,preorder.length-1);
        
    }
}