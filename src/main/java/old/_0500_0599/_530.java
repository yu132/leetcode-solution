package old._0500_0599;

import model.TreeNode;

public class _530 {
	
	class Solution {
		
		int before;
		boolean flag = true;
		
		int min = Integer.MAX_VALUE;
		
		public void inorder(TreeNode node) {
			if (node == null)
				return;
			inorder(node.left);
			
			if (flag) {
				before = node.val;
				flag = false;
			} else {
				int val = Math.abs(node.val - before);
				if (val < min)
					min = val;
				before = node.val;
			}
			
			inorder(node.right);
		}
		
		public int getMinimumDifference(TreeNode root) {
			inorder(root);
			if (flag)
				return 0;
			return min;
		}
	}
	
}
