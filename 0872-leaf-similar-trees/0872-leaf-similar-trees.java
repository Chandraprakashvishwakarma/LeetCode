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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr = new ArrayList<>();
        inOrderLeafSeq(root1,arr);
        int [] i = new int [1];
        return findSimilar(root2,arr,i) && i[0]==arr.size();
    }
    public boolean findSimilar(TreeNode root,List<Integer> arr,int [] i){
        if(root.left == null && root.right ==null ){
            if(i[0]>=arr.size()) return false;
            if(arr.get(i[0])!=root.val) return false;
            else i[0]++;
        }
        boolean flag = true;
        if(root.left != null) flag = flag && findSimilar(root.left,arr,i);
        if(root.right != null) flag = flag && findSimilar(root.right,arr,i);
        
        return flag;
        
    }
    
    
    public void inOrderLeafSeq(TreeNode root,List<Integer> arr){
        if(root.left == null && root.right == null){
            arr.add(root.val);
        }
        if(root.left!=null) inOrderLeafSeq(root.left,arr);
        
        if(root.right!=null) inOrderLeafSeq(root.right,arr);
    }
}