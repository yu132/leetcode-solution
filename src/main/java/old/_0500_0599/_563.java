package old._0500_0599;

import model.TreeNode;

public class _563 {
	
	class Solution {
		
		int result = 0;
		
		public int sum(TreeNode node) {
			if (node == null)
				return 0;
			
			int l = sum(node.left);
			int r = sum(node.right);
			
			result += Math.abs(l - r);
			
			return node.val + l + r;
		}
		
		public int findTilt(TreeNode root) {
			sum(root);
			return result;
		}
	}
	
}
