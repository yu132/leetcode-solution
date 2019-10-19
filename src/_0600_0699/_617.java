package _0600_0699;

import model.TreeNode;

public class _617 {
	
	class Solution {
		
	    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	        
	    	if(t1==null&&t2==null) {
	    		return null;
	    	}
	    	
	    	if(t1==null) {
	    		TreeNode temp=new TreeNode(t2.val);
	    		temp.left=mergeTrees(null,t2.left);
	    		temp.right=mergeTrees(null,t2.right);
	    		return temp;
	    	}
	    	
	    	if(t2==null) {
	    		TreeNode temp=new TreeNode(t1.val);
	    		temp.left=mergeTrees(t1.left,null);
	    		temp.right=mergeTrees(t1.right,null);
	    		return temp;
	    	}
	    	
	    	TreeNode temp=new TreeNode(t1.val+t2.val);
    		temp.left=mergeTrees(t1.left,t2.left);
    		temp.right=mergeTrees(t1.right,t2.right);
    		return temp;
	    }
	}
	
//	class Solution {
//	    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//	        if(t1 == null) return t2;
//	        if(t2 == null) return t1;
//	        TreeNode result = new TreeNode(t1.val + t2.val);
//	        result.left = mergeTrees(t1.left,t2.left);
//	        result.right = mergeTrees(t1.right,t2.right);
//	        return result;
//	    }
//	}
	
}
