package _0500_0599;

import model.TreeNode;

public class _572 {
	
	class Solution {
		
		public boolean same(TreeNode s, TreeNode t) {
			if (s == null) {
				if (t == null) {
					return true;
				}
				return false;
			} else {
				if (t == null) {
					return false;
				}
				
				if (s.val == t.val) {
					if (same(s.left, t.left) && same(s.right, t.right))
						return true;
				}
				
				return false;
			}
		}
		
		public boolean isSubtree(TreeNode s, TreeNode t) {
			
			if (same(s, t)) {
				return true;
			}
			
			if (s == null) {
				return false;
			}
			
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
	}
	
}
