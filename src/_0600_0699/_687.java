package _0600_0699;

import model.TreeNode;

public class _687 {
	
	class Solution {
		
		private int max = Integer.MIN_VALUE;
		
		public int level(TreeNode root, int fv) {
			if (root == null) {
				return 0;
			}
			int	left	= level(root.left, root.val);
			int	right	= level(root.right, root.val);
			max = Math.max(max, left + right);
			if (root.val == fv) {
				return 1 + Math.max(left, right);
			}
			return 0;
		}
		
		public int longestUnivaluePath(TreeNode root) {
			if (root == null) {
				return 0;
			}
			level(root, root.val);
			return max;
		}
	}
	
}
