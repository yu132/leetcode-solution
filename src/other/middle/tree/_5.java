package other.middle.tree;

import model.TreeNode;

public class _5 {

	class Solution {
		
		int count=0;
		
		public int kthSmallest(TreeNode root, int k) {
	    	return find(root,k);
	    }
		
		private Integer find(TreeNode root, int k) {
			if(root==null)
				return null;
			
	    	Integer val=find(root.left,k);
	    	
	    	if(val!=null)
	    		return val;
	    	
	    	count++;
	    	if(count==k)
	    		return root.val;
	    	
	    	return find(root.right,k);
	    }
	}
	
}
