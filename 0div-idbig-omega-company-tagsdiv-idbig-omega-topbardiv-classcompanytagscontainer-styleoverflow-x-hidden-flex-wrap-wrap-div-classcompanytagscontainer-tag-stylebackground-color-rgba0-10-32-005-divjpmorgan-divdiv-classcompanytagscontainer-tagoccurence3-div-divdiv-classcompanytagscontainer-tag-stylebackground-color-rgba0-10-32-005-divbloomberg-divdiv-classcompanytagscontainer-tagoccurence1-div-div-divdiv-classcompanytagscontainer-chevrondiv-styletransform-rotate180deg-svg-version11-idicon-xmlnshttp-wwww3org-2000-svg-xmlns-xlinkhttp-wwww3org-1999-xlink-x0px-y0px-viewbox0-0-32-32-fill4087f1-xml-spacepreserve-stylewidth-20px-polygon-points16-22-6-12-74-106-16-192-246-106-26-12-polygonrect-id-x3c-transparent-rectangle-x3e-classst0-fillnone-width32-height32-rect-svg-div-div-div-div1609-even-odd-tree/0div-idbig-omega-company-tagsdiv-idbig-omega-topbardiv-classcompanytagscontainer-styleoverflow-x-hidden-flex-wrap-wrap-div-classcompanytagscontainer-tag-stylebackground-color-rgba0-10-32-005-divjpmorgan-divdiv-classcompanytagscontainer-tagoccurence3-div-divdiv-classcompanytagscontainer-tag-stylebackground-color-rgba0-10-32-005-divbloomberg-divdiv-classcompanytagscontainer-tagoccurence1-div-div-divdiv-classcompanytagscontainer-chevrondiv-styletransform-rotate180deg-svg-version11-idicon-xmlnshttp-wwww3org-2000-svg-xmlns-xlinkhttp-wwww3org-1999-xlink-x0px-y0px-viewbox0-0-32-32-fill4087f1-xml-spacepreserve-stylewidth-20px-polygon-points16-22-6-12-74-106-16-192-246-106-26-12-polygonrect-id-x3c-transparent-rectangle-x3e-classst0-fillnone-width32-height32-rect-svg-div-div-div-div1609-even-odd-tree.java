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
    public boolean isEvenOddTree(TreeNode root) {
        int i = 0;
        boolean flag = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            if(i%2 == 0) flag = true;
            else flag = false;
            if(flag){
                int pre = 0;
                for(int j=0;j<s;j++){
                    TreeNode node = q.poll();
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                    int val = node.val;
                    if(val%2 == 0) return false;
                    if(j == 0) {
                        pre = val;
                        continue;
                    }
                    else if(val<=pre) return false;
                    pre = val;
                }
            }
            else{
                int pre = 0;
                for(int j=0;j<s;j++){
                    TreeNode node = q.poll();
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                    int val = node.val;
                    if(val%2 != 0) return false;
                    if(j == 0) {
                        pre = val;
                        continue;
                    }
                    else if(val>=pre) return false;
                    pre = val;
                }
            }
            i++;
        }
        return true;
    }
}