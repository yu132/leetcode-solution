package _0600_0699;

import java.util.HashSet;
import java.util.Set;

import model.TreeNode;

public class _653 {
	
	class Solution {
		
		private Set<Integer> set = new HashSet<>();
		
		public boolean findTarget(TreeNode root, int k) {
			
			if (root == null) {
				return false;
			}
			
			if (set.contains(k - root.val)) {
				return true;
			}
			
			set.add(root.val);
			
			if (findTarget(root.left, k)) {
				return true;
			}
			
			if (findTarget(root.right, k)) {
				return true;
			}
			
			return false;
		}
	}
	
}
