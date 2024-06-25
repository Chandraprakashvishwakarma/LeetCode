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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> ar = new ArrayList<>();
        inorder(root,ar);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<ar.size();i++) min = Math.min(min,ar.get(i)-ar.get(i-1));
        return min;
    }
    public void inorder(TreeNode root,List<Integer> ar){
        if(root == null) return ;
        inorder(root.left,ar);
        ar.add(root.val);
        inorder(root.right,ar);
    }
}