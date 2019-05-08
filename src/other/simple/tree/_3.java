package other.simple.tree;

import model.TreeNode;

public class _3 {

	class Solution {
	    public boolean isSymmetric(TreeNode root) {
	        if(root==null)
	        	return true;
	        
	        return isSymmetric(root.left,root.right);
	    }
	    
	    public boolean isSymmetric(TreeNode left,TreeNode right) {
	    	if(left==null&&right==null)
	    		return true;
	    	
	    	if(left==null||right==null||left.val!=right.val)
	    		return false;
	        
	        return isSymmetric(left.left,right.right)&&isSymmetric(right.left,left.right);
	    }
	}
	
}
