package other.middle.tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class _1 {

	class Solution {
		
		List<Integer> ans=new ArrayList<>();
		
	    public List<Integer> inorderTraversal(TreeNode root) {
	    	if(root==null)
	    		return ans;
	    	inorderTraversal(root.left);
	    	ans.add(root.val);
	    	inorderTraversal(root.right);
	    	return ans;
	    }
	}
	
}
