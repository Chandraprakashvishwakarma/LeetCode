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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int i:to_delete) set.add(i);
        List<TreeNode> res = new ArrayList<>();
        helper(root,res,set);
        if(!set.contains(root.val)) {
            res.add(root);
        }
        return res;
    }
    private TreeNode helper(TreeNode root,List<TreeNode> res,Set<Integer> set){
        if(root == null) return null;
        root.left = helper(root.left,res,set);
        root.right = helper(root.right,res,set);
        
        
        if(set.contains(root.val)){
            if(root.left!=null && !set.contains(root.left.val)) {
                res.add(root.left);
            }
            if(root.right!=null && !set.contains(root.right.val)) {
                res.add(root.right);
            }
            return null;
        }
        return root;
    }
}