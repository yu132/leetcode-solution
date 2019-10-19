package _0100_0199;

import java.util.ArrayDeque;
import java.util.Deque;

import model.TreeNode;


public class _173 {

	class BSTIterator {
		
		private Deque<TreeNode> stack=new ArrayDeque<>();

	    public BSTIterator(TreeNode root) {
	        while(root!=null){
	        	stack.addLast(root);
	        	root=root.left;
	        }
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	    	TreeNode node=stack.removeLast();
	    	
	    	int val=node.val;
	    	
    		node=node.right;
    		while(node!=null){
    			stack.addLast(node);
    			node=node.left;
    		}
	    	
	    	return val;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }
	}
	
}
