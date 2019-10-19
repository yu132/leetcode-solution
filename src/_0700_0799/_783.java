package _0700_0799;

import model.TreeNode;

public class _783 {
	
	class Solution {
		
		private boolean	flag	= true;
		private int		before;
		private int		diff	= Integer.MAX_VALUE;
		
		private void inorder(TreeNode node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			
			if (flag) {
				flag	= false;
				before	= node.val;
			} else {
				diff	= Math.min(diff, node.val - before);
				before	= node.val;
			}
			
			inorder(node.right);
		}
		
		public int minDiffInBST(TreeNode root) {
			inorder(root);
			return diff;
		}
	}
	
}
