package old._0800_0899;

import model.TreeNode;

public class _897 {
	
	class Solution {
		
		public TreeNode increasingBST(TreeNode root) {
			if (root == null) {
				return root;
			}
			TreeNode res = increasingBST(root.left, root);
			root.left	= null;
			root.right	= increasingBST(root.right, null);
			return res;
		}
		
		public TreeNode increasingBST(TreeNode root, TreeNode tail) {
			if (root == null) {
				return tail;
			}
			TreeNode res = increasingBST(root.left, root);
			root.left	= null;
			root.right	= increasingBST(root.right, tail);
			return res;
		}
		
	}
	
}
