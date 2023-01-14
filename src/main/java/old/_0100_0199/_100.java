package old._0100_0199;

import model.TreeNode;

public class _100 {

	class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        if(p==null&&q==null)	return true;
	        if(p==null||q==null)	return false;
        	return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	    }
	}
	
}
