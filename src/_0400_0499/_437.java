package _0400_0499;

import model.TreeNode;

public class _437 {

	class Solution {
		
		int count=0;
		
	    public int pathSum(TreeNode root, int sum) {
	    	dfs1(root,sum);
	    	
	    	return count;
	    }
	    
	    void dfs1(TreeNode node,int sum){
	    	if(node==null)
	    		return;
	    	
	    	dfs(node,0,sum);
	    	
	    	dfs1(node.left,sum);
	    	dfs1(node.right,sum);
	    }
	    
	    void dfs(TreeNode node,int nowSum,int sum){
	    	if(node==null)
	    		return;
	    	
	    	nowSum+=node.val;
	    	
	    	if(nowSum==sum){
	    		System.out.println(node.val);
	    		++count;
	    	}
	    	
	    	dfs(node.left,nowSum,sum);
	    	dfs(node.right,nowSum,sum);
	    }
	}
	
}
