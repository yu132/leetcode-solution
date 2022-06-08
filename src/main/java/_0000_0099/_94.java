package _0000_0099;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import model.TreeNode;

public class _94 {
	
	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			
			Deque<TreeNode>	dq	= new ArrayDeque<>();//双端队列作为栈使用
			
			List<Integer>	ans	= new ArrayList<>();
			
			while (root != null || !dq.isEmpty()) {
				if (root != null) {//将所有该节点和所以最左边的节点压入栈
					while (root != null) {
						dq.addLast(root);
						root = root.left;
					}
				} else {//由于是栈，所以左节点总是在父节点前弹出，也被更早遍历
					root = dq.removeLast();
					ans.add(root.val);//遍历当前节点
					root = root.right;//将右子树设置为需要遍历的对象，然后上面会将右子树的
										//所有左节点压入栈
				}
			}
			
			return ans;
		}
	}
	
}
