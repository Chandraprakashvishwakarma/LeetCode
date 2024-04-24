/*
Q. no. 130: Construct Binary Tree from Preorder and Inorder Traversal
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++) map.put(inorder[i],i);
        return buildTree(preorder,0,n-1,inorder,0,n-1,map);
    }
    private TreeNode buildTree(int[] preorder,int pS,int pE, int[] inorder,int iS,int iE,Map<Integer,Integer> map){
        if(pS>pE || iS>iE) return null;
        
        TreeNode root = new TreeNode(preorder[pS]);
        int idx = map.get(preorder[pS]);
        int l = idx-iS;
        int r = iE-idx;
        
        root.left = buildTree(preorder,pS+1,pS+l,inorder,iS,idx-1,map);
        root.right = buildTree(preorder,pE-r+1,pE,inorder,idx+1,iE,map);
        
        return root;
    }
}

/*

Codding Ninjas: 

import java.util.* ;
import java.io.*; 

public class Solution 
{
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        Map < Integer, Integer > inMap = new HashMap < Integer, Integer > ();
    for (int i = 0; i < inorder.size(); i++) {
      inMap.put(inorder.get(i), i);
    }
    TreeNode<Integer> root = buildTree(preorder, 0, preorder.size() - 1, inorder, 0, 
    inorder.size() - 1, inMap);
    return root;
    }
    public static TreeNode<Integer> buildTree(ArrayList<Integer> preorder, int preStart, int preEnd, ArrayList<Integer>
  inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
    if (preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder.get(preStart));
    int inRoot = inMap.get(root.data);
    int numsLeft = inRoot - inStart;

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, 
    inStart, inRoot - 1, inMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, 
    inRoot + 1, inEnd, inMap);

    return root;
  }
}


*/
