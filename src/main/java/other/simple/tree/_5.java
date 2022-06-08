package other.simple.tree;

import model.TreeNode;

public class _5 {

	class Solution {
	    public TreeNode sortedArrayToBST(int[] nums) {
	        return sortedArrayToBST(nums,0,nums.length-1);
	    }
	    
	    public TreeNode sortedArrayToBST(int[] nums,int f,int b) {
	    	if(f>b)
	    		return null;
	    	
	    	int mid=f+(b-f)/2;
	    	
	    	TreeNode t=new TreeNode(nums[mid]);
	    	
	    	t.left=sortedArrayToBST(nums,f,mid-1);
	    	t.right=sortedArrayToBST(nums,mid+1,b);
	    	
	    	return t;
	    }
	}
	
}
