package _0700_0799;

import model.TreeNode;

public class _700 {
	
	class Solution {
		public TreeNode searchBST(TreeNode root, int val) {
			if (root == null) {
				return null;
			}
			if (val == root.val) {
				return root;
			}
			if (val < root.val) {
				return searchBST(root.left, val);
			}
			return searchBST(root.right, val);
		}
	}
	
}
