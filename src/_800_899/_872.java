package _800_899;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class _872 {
	
	class Solution {
		
		private void dfs(TreeNode node, List<Integer> list) {
			if (node == null) {
				return;
			}
			if (node.left == null && node.right == null) {
				list.add(node.val);
				return;
			}
			dfs(node.left, list);
			dfs(node.right, list);
		}
		
		public boolean leafSimilar(TreeNode root1, TreeNode root2) {
			List<Integer>	a	= new ArrayList<>();
			List<Integer>	b	= new ArrayList<>();
			dfs(root1, a);
			dfs(root2, b);
			return a.equals(b);
		}
	}
	
}
