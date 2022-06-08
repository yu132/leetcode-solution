package _0000_0099;

import model.TreeNode;

public class _98 {
	
	class Solution {
		public boolean isValidBST(TreeNode root) {
			if (root == null)
				return true;
			
			return isValidBST(root.left, root.val, Long.MIN_VALUE)
					&& isValidBST(root.right, Long.MAX_VALUE, root.val);
		}
		
		public boolean isValidBST(TreeNode root, long greater, long smaller) {
			if (root == null)
				return true;
			
			if (root.val >= greater || root.val <= smaller)
				return false;
			
			return isValidBST(root.left, root.val, smaller)
					&& isValidBST(root.right, greater, root.val);
		}
	}
	
}
