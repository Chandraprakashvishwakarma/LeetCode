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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,Trio> map = new HashMap<>();
        for(int [] des:descriptions){
            if(!map.containsKey(des[0])) map.put(des[0],new Trio(des[0],new TreeNode(des[0]),true));
            if(!map.containsKey(des[1])) map.put(des[1],new Trio(des[1],new TreeNode(des[1]),false));
            else map.get(des[1]).isRoot=false;
            if(des[2] == 1) map.get(des[0]).node.left = map.get(des[1]).node;
            else map.get(des[0]).node.right = map.get(des[1]).node;
        }
        for(int i:map.keySet()) if(map.get(i).isRoot) return map.get(i).node;
        return null;
    }
}

class Trio{
    int val;
    TreeNode node;
    boolean isRoot;
    public Trio(int val,TreeNode node,boolean isRoot){
        this.val = val;
        this.node = node;
        this.isRoot = isRoot;
    }
}