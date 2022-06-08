package _1000_1099;

import model.TreeNode;

public class _1022 {
	
	class Solution {
		
		private final static int bound = 1000000007;
		
		public long sum(TreeNode root, long before) {
			if (root == null) {
				return 0;
			}
			long now = (before << 1) + root.val;
			if (root.left == null && root.right == null) {
				return now % bound;
			} else {
				return (sum(root.left, now) + sum(root.right, now)) % bound;
			}
		}
		
		public int sumRootToLeaf(TreeNode root) {
			return (int) sum(root, 0);
		}
	}
	
}
