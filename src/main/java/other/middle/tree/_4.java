package other.middle.tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeLinkNode;

public class _4 {
	public class Solution {
		public void connect(TreeLinkNode root) {
	    	List<List<TreeLinkNode>> res=new ArrayList<>();
	    	
	    	eachNode(root,0, res);
	    	
	    	for(int i=1;i<res.size();i++){
	    		List<TreeLinkNode> list=res.get(i);
	    		
	    		for(int j=0;j<list.size()-1;j++){
	    			list.get(j).next=list.get(j+1);
	    		}
	    	}
	    	
	    }	 	  
	    
	    public void eachNode(TreeLinkNode node,int level,List<List<TreeLinkNode>> res) {
	    	if(node==null)
	    		return;
	    	
	        while(res.size()<=level)
	        	res.add(new ArrayList<TreeLinkNode>());
	        
	        res.get(level).add(node);
	        
	        eachNode(node.left,level+1,res);
	        eachNode(node.right,level+1,res);
	    }
	}
	
}
