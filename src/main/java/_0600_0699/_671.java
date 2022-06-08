package _0600_0699;

import model.TreeNode;

public class _671 {
	
	class Solution {
		
		public int level(TreeNode root, int fv) {
			if (root == null) {
				return -1;
			}
			if (root.val == fv) {
				int	left	= level(root.left, fv);
				int	right	= level(root.right, fv);
				if (left == -1) {
					return right;
				} else if (right == -1) {
					return left;
				} else {
					return Math.min(left, right);
				}
			}
			return root.val;
		}
		
		public int findSecondMinimumValue(TreeNode root) {
			if (root == null) {
				return -1;
			}
			return level(root, root.val);
		}
	}
	
}
