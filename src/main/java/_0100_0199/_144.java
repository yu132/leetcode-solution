package _0100_0199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import model.TreeNode;

public class _144 {
	
	class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			
			Deque<TreeNode>	dq	= new ArrayDeque<>();//双端队列作为栈使用
			
			List<Integer>	ans	= new ArrayList<>();
			
			if (root == null) {
				return ans;
			}
			
			dq.addFirst(root);
			
			while (!dq.isEmpty()) {
				TreeNode node = dq.removeFirst();//先遍历父节点
				ans.add(node.val);
				if (node.right != null) {//先将右边压入栈，右子节点后遍历
					dq.addFirst(node.right);
				}
				if (node.left != null) {//再将左边压入栈，左子节点先遍历
					dq.addFirst(node.left);
				}
			}
			
			return ans;
		}
	}
	
}
