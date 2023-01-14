package old._0000_0099;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import model.TreeNode;

public class _94 {
	
	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			
			Deque<TreeNode>	dq	= new ArrayDeque<>();//˫�˶�����Ϊջʹ��
			
			List<Integer>	ans	= new ArrayList<>();
			
			while (root != null || !dq.isEmpty()) {
				if (root != null) {//�����иýڵ����������ߵĽڵ�ѹ��ջ
					while (root != null) {
						dq.addLast(root);
						root = root.left;
					}
				} else {//������ջ��������ڵ������ڸ��ڵ�ǰ������Ҳ���������
					root = dq.removeLast();
					ans.add(root.val);//������ǰ�ڵ�
					root = root.right;//������������Ϊ��Ҫ�����Ķ���Ȼ������Ὣ��������
										//������ڵ�ѹ��ջ
				}
			}
			
			return ans;
		}
	}
	
}
