package _0800_0899;

import model.TreeNode;

public class _814 {

	class Solution {
	    public TreeNode pruneTree(TreeNode root) {
	        
	    	if(root==null) return null;
	    	
	    	root.left=pruneTree(root.left);
	    	root.right=pruneTree(root.right);
	    	
	    	if(root.left==null&&root.right==null&&root.val!=1)
	    		return null;
	    	else
	    		return root;
	    }
	}
	
}
