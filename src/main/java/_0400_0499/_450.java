package _0400_0499;

import model.TreeNode;

public class _450 {

	class Solution {
	    public TreeNode deleteNode(TreeNode root, int key) {
	    	
	    	if(root==null){
	            return null;
	        }
	    	
	    	if(root.val>key){
	    		root.left=deleteNode(root.left,key);
	    		return root;
    		}else if(root.val<key){
    			root.right=deleteNode(root.right,key);
    			return root;
    		}else{
    			if(root.left==null){
    				return root.right;
    			}else if(root.right==null){
    				return root.left;
    			}else{
    				TreeNode successor = min(root.right);
                    successor.right = deleteMin(root.right);
                    successor.left = root.left;
                    return successor;
    			}
    		}
	    }
	    
	    private TreeNode min(TreeNode node) {
	        if (node.left == null) {
	            return node;
	        }
	        return min(node.left);
	    }

	    private TreeNode deleteMin(TreeNode node) {
	        if (node.left == null) {
	            return node.right;
	        }
	        node.left = deleteMin(node.left);
	        return node;
	    }
	}
	
}
