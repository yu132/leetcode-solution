package old._0900_0999;

import model.TreeNode;

public class _965 {
	
	class Solution {
		public boolean isUnivalTree(TreeNode root) {
			return isUnivalTree(root, root.val);
		}
		
		public boolean isUnivalTree(TreeNode root, int value) {
			if (root == null) {
				return true;
			}
			if (root.val != value) {
				return false;
			}
			return isUnivalTree(root.left, value) &&
					isUnivalTree(root.right, value);
		}
	}
	
}
