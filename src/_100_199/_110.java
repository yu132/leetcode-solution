package _100_199;

import model.TreeNode;

public class _110 {

	class Solution {
	    public boolean isBalanced(TreeNode root) {
	    	return dfs(root)!=-1;
	    }
	    
	    public int dfs(TreeNode node){
	    	if(node==null)
	    		return 0;
	    	
	    	int lenl=dfs(node.left);
	    	
	    	if(lenl==-1)
	    		return -1;
	    	
	    	int lenr=dfs(node.right);
	    	
	    	if(lenr==-1)
	    		return -1;
	    	
	    	if(Math.abs(lenl-lenr)>1)
	    		return -1;
	    	else
	    		return Math.max(lenl, lenr)+1;
	    }
	}
	
}
