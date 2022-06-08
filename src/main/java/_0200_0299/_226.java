package _0200_0299;

import model.TreeNode;

public class _226 {

	class Solution {
	    public TreeNode invertTree(TreeNode root) {
	        if(root==null)
	        	return null;
	        TreeNode right=root.right;
	        
	        root.right=invertTree(root.left);
	        root.left=invertTree(right);
	        
	        return root;
	    }
	}
	
}
