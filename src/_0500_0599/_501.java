package _0500_0599;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class _501 {
	
	class Solution {
		
		int now = Integer.MIN_VALUE;
		int count = -3;
		
		List<Integer> modes = new ArrayList<>();
		int max = -2;
		
		public void inorder(TreeNode root) {
			if (root == null)
				return;
			inorder(root.left);
			
			if (root.val == now) {
				++count;
			} else {
				if (count > max) {
					max = count;
					modes.clear();
					modes.add(now);
				} else if (count == max) {
					modes.add(now);
				}
				now = root.val;
				count = 0;
			}
			
			inorder(root.right);
		}
		
		public int[] findMode(TreeNode root) {
			inorder(root);
			
			if (count > max) {
				max = count;
				modes.clear();
				modes.add(now);
			} else if (count == max) {
				modes.add(now);
			}
			
			int[] ans = new int[modes.size()];
			for (int i = 0; i < modes.size(); ++i) {
				ans[i] = modes.get(i);
			}
			return ans;
		}
	}
	
	
}
