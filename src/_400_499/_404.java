package _400_499;

import model.TreeNode;

public class _404 {
/* v1 same 多加了样例所以时间长了
	class Solution {
	    public int sumOfLeftLeaves(TreeNode root) {
	        if(root==null)
	        	return 0;
	        return sumLeft(root.left)+sumOfLeftLeaves(root.right);
	    }
	    public int sumLeft(TreeNode root){
	    	if(root==null)
	    		return 0;
	    	if(root.left==null&&root.right==null)
	    		return root.val;
	    	return sumLeft(root.left)+sumOfLeftLeaves(root.right);
	    }
	}*/
	
	class Solution {
	    public int sumOfLeftLeaves(TreeNode root) {
	        if(root==null)
	        	return 0;
	        if(root.left!=null&&root.left.left==null&&root.left.right==null)
	        	return root.left.val+sumOfLeftLeaves(root.right);
	        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
	    }
	}
	
}
