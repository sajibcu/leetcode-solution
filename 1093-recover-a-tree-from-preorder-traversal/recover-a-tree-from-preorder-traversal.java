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
        Map<Integer,List<TreeNode>> mp = new HashMap<>();
        int i = 0;
        int l = traversal.length();
        int d = 0;
        TreeNode root = new TreeNode();
        mp.put(0, List.of(root) );
        int val = 0;
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
                //System.out.println(d+"##"+val);
                TreeNode node = new TreeNode(val);
                List<TreeNode> tempNodes = mp.get(d-1);
                TreeNode lastNode = tempNodes.get(tempNodes.size() - 1);
                if(lastNode.left == null){
                    lastNode.left = node;
                }else{
                    lastNode.right = node;
                }
                

               mp.putIfAbsent(d, new ArrayList<>());
                mp.get(d).add(node);
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