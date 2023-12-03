/*
Q. no. 113: Binary Tree Postorder Traversal
*/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        postOrder(root,res);
        return res;
    }
    public void postOrder(TreeNode root,List<Integer> res){
        if(root == null) return ;
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }
}

/*
Codding Ninjas:

public class Solution {
    public static List < Integer > getPostOrderTraversal(TreeNode root) {
    	// Write your code here.
        List < Integer > res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public static void helper(TreeNode root,List<Integer> res){
        if(root == null) return ;
        helper(root.left,res);
        helper(root.right,res);
        res.add(root.data);
    }
}
*/