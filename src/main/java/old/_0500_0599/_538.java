package old._0500_0599;

import model.TreeNode;

public class _538 {
	
	class Solution {
		
		int sum = 0;
		
		public void rnl(TreeNode node) {
			if (node == null)
				return;
			
			rnl(node.right);
			
			int temp = node.val;
			node.val += sum;
			sum += temp;
			
			rnl(node.left);
		}
		
		public TreeNode convertBST(TreeNode root) {
			rnl(root);
			return root;
		}
	}
	
}
