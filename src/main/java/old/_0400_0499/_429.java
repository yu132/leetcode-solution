package old._0400_0499;

import java.util.ArrayList;
import java.util.List;

public class _429 {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}

	class Solution {
		
		private List<List<Integer>> ans=new ArrayList<>();
		
	    public List<List<Integer>> levelOrder(Node root) {
	        dfs(root,0);
	        return ans;
	    }
	    
	    public void dfs(Node node,int level){
	    	if(node==null)
	    		return;
	    	while(ans.size()<level+1){
	    		ans.add(new ArrayList<>());
	    	}
	    	
	    	ans.get(level).add(node.val);
	    	
	    	for(Node n:node.children){
	    		dfs(n,level+1);
	    	}
	    }
	    
	}
	
}
