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
    public int kthSmallest(TreeNode root, int k) {
        int [] ans = new int []{0};
        helper(root,new int[]{1},k,ans);
        return ans[0];
    }
    
    public void helper(TreeNode root , int [] count,int k, int [] ans){
        if(root == null) return ;
        helper(root.left,count,k,ans);
        if(k == count[0]){
            ans[0] = root.val;
        }
        count[0]++;
        helper(root.right,count,k,ans);
    }
}