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
    public TreeNode recoverFromPreorder(String traversal) {
        Map<Integer,Stack<TreeNode>> mp = new HashMap<>();
        int l = traversal.length();
        int d = 0;

        TreeNode root = new TreeNode();
        mp.put(0, new Stack<>());
        mp.get(0).push(root);

        int val = 0,i=0;
        while( i < l) {
            val = 0;

            // value
            while(i < l && traversal.charAt(i) != '-'){
                val = val*10 + traversal.charAt(i) - '0';
                i++;
            }
            
            if(d == 0){
                root.val = val;
            }else {
                TreeNode node = new TreeNode(val);
                TreeNode lastNode = mp.get(d-1).peek();
                if(lastNode.left == null){
                    lastNode.left = node;
                }else{
                    lastNode.right = node;
                }
                

               mp.putIfAbsent(d, new Stack<>());
                mp.get(d).push(node);
            }

            // depth
            d=0;
            while(i < l && traversal.charAt(i) == '-'){
                d++;
                i++;
            }
        }

        return root;

    }
}