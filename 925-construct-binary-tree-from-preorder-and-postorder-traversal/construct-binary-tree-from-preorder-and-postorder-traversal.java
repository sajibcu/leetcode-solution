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
    HashMap<Integer,Integer> preeMp;
    HashMap<Integer,Integer> postMp;
    public TreeNode constract( int[] preorder,int[] postorder, int l,int r) {
        if (l > r) return null;
        int val = preorder[l];
        TreeNode root = new TreeNode(val);
        
        if(l==r) {
            return root;
        }
        
        int postIndex = postMp.get(val) -1 ;
        if (postIndex < 0 ) return root;
       
        int preIndex = preeMp.get(postorder[postIndex]);
        root.left = constract(preorder,postorder,l+1, preIndex-1);
        root.right = constract(preorder,postorder,preIndex, r);

        return root;



    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preeMp = new HashMap<>();
        postMp = new HashMap<>();
        for(int i =0;i<postorder.length; i++){
            preeMp.put(preorder[i],i);
            postMp.put(postorder[i],i);
        }
       return constract(preorder,postorder,0,preorder.length-1);
        
    }
}