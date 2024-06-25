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
        //ar[0] = pre element ar[1]=ans
        ar.add(Integer.MAX_VALUE);ar.add(Integer.MAX_VALUE);
        inorder(root,ar);
        return ar.get(1);
    }
    public void inorder(TreeNode root,List<Integer> ar){
        if(root == null) return ;
        inorder(root.left,ar);
        ar.set(1,Math.min(ar.get(1),Math.abs(root.val-ar.get(0))));
        ar.set(0,root.val);
        inorder(root.right,ar);
    }
}