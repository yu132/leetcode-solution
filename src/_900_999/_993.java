package _900_999;

import model.TreeNode;

public class _993 {
	
	class Solution {
		
		int xl, yl, xp, yp;
		
		public void dfs(TreeNode root, int x, int y, int parent, int level) {
			if (root == null) {
				return;
			}
			if (root.val == x) {
				xl	= level;
				xp	= parent;
			} else if (root.val == y) {
				yl	= level;
				yp	= parent;
			} else {
				dfs(root.left, x, y, root.val, level + 1);
				dfs(root.right, x, y, root.val, level + 1);
			}
		}
		
		public boolean isCousins(TreeNode root, int x, int y) {
			dfs(root.left, x, y, root.val, 1);
			dfs(root.right, x, y, root.val, 1);
			return xl == yl && xp != yp;
		}
	}
	
}
