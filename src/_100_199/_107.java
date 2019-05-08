package _100_199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.TreeNode;

public class _107 {

	class Solution {
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    	List<List<Integer>> ans=new ArrayList<>();
	    	
	    	dfs(ans, 0, root);
	    	
	    	Collections.reverse(ans);
	    	
	    	return ans;
	    }
	    
	    public void dfs(List<List<Integer>> ans,int level,TreeNode node){
	    	if(node==null)
	    		return;
	    	
	    	while(ans.size()<=level){
	    		ans.add(new ArrayList<>());
	    	}
	    	
	    	List<Integer> levelAns=ans.get(level);
	    	
	    	levelAns.add(node.val);
	    	
	    	dfs(ans, level+1, node.left);
	    	dfs(ans, level+1, node.right);
	    }
	}
	
}
