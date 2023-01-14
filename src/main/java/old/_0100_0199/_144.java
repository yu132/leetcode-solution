package old._0100_0199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import model.TreeNode;

public class _144 {
	
	class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			
			Deque<TreeNode>	dq	= new ArrayDeque<>();//˫�˶�����Ϊջʹ��
			
			List<Integer>	ans	= new ArrayList<>();
			
			if (root == null) {
				return ans;
			}
			
			dq.addFirst(root);
			
			while (!dq.isEmpty()) {
				TreeNode node = dq.removeFirst();//�ȱ������ڵ�
				ans.add(node.val);
				if (node.right != null) {//�Ƚ��ұ�ѹ��ջ�����ӽڵ�����
					dq.addFirst(node.right);
				}
				if (node.left != null) {//�ٽ����ѹ��ջ�����ӽڵ��ȱ���
					dq.addFirst(node.left);
				}
			}
			
			return ans;
		}
	}
	
}
