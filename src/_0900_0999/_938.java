package _0900_0999;

import model.TreeNode;

public class _938 {
	
	class Solution {
		
		int sum = 0;
		
		public int rangeSumBST(TreeNode root, int L, int R) {
			if (root == null) {
				return sum;
			}
			rangeSumBST(root.left, L, R);
			if (root.val >= L && root.val <= R) {
				sum += root.val;
			}
			rangeSumBST(root.right, L, R);
			return sum;
		}
	}
	
}
