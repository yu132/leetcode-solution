package old._0500_0599;

import model.TreeNode;

public class _543 {

	class Solution {
		
		int max=0;
		
	    public int diameterOfBinaryTree(TreeNode root) {
	    	dfs(root);
	        return max;
	    }
	    
	    public int dfs(TreeNode node){
	    	if(node==null)
	    		return 0;
	    	
	    	int len1=dfs(node.left);
	    	int len2=dfs(node.right);
	    	
	    	max=Math.max(max,len1+len2);
	    	
	    	return Math.max(len1, len2)+1;
	    }
	}
	
}
