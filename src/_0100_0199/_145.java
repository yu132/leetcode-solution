package _0100_0199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

public class _145 {
	
	class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			
			LinkedList<TreeNode>	stack	= new LinkedList<>();
			
			List<Integer>			ans		= new ArrayList<>();
			
			stack.push(root);
			stack.push(root);
			
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				if (node == null) {
					continue;
				}
				if (!stack.isEmpty() && node == stack.peek()) {
					stack.push(node.right);
					stack.push(node.right);
					stack.push(node.left);
					stack.push(node.left);
				} else {
					ans.add(node.val);
				}
			}
			
			return ans;
		}
	}
	
}
