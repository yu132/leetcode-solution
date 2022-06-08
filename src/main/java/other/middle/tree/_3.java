package other.middle.tree;

import model.TreeNode;

public class _3 {

	class Solution {
		
		int[] preorder;
		int index=0;
		
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        this.preorder=preorder;
	        return buildTree(inorder,0,inorder.length-1);
	    }
	    
	    public TreeNode buildTree(int[] inorder,int f,int b) {
	    	if(f>b)
	    		return null;
	    	
	        int midValue=preorder[index++];
	        int mid=f;
	        for(;mid<=b+1;mid++){
	        	if(inorder[mid]==midValue)
	        		break;
	        }
	        
	        if(mid==b+1)
	        	return null;
	        
	        TreeNode t=new TreeNode(inorder[mid]);
	        
	        t.left=buildTree(inorder,f,mid-1);
	        t.right=buildTree(inorder,mid+1,b);
	        
	        return t;
	    }
	}
	
}
