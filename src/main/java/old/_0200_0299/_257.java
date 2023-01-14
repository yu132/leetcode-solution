package old._0200_0299;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class _257 {

	class Solution {
		
		List<Integer> list=new ArrayList<>();
		List<String> ans=new ArrayList<>();
		
	    public List<String> binaryTreePaths(TreeNode root) {
	        if(root==null)
	        	return ans;
	        dfs(root);
	        return ans;
	    }
	    
	    public void dfs(TreeNode node){
	    	if(node.left==null&&node.right==null){
	    		
	    		list.add(node.val);
	    		
	    		StringBuilder sb=new StringBuilder();
	    		
	    		for(int i=0;i<list.size()-1;i++){
	    			sb.append(list.get(i)).append("->");
	    		}
	    		
	    		sb.append(list.get(list.size()-1));
	    		
	    		ans.add(sb.toString());
	    		
	    		list.remove(list.size()-1);
	    		
	    		return;
	    	}
	    	
	    	if(node.left!=null){
	    		list.add(node.val);
	    		dfs(node.left);
	    		list.remove(list.size()-1);
	    	}
	    	
	    	if(node.right!=null){
	    		list.add(node.val);
	    		dfs(node.right);
	    		list.remove(list.size()-1);
	    	}
	    }
	}
	
}
