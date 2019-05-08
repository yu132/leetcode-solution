package other.simple.tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class _4 {

	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	    	List<List<Integer>> res=new ArrayList<>();
	    	
	    	eachNode(root,0, res);
	    	
	    	return res;
	    }
	    
	    public void eachNode(TreeNode node,int level,List<List<Integer>> res) {
	    	if(node==null)
	    		return;
	    	
	        while(res.size()<=level)
	        	res.add(new ArrayList<Integer>());
	        
	        res.get(level).add(node.val);
	        
	        eachNode(node.left,level+1,res);
	        eachNode(node.right,level+1,res);
	    }
	}
	
}
