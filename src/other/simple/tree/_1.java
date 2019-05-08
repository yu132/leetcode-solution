package other.simple.tree;

import model.TreeNode;

public class _1 {

	class Solution {
	    public int maxDepth(TreeNode root) {
	        if(root==null)
	        	return 0;
	        
	        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	    }
	}
	
}
