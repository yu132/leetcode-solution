package _0500_0599;

import java.util.List;

public class _559 {
	
	class Node {
		public int val;
		public List<Node> children;
		
		public Node() {}
		
		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
	
	class Solution {
		
		public int maxDepth(Node root) {
			if (root == null) {
				return 0;
			}
			int max = 1;
			for (int i = 0; i < root.children.size(); ++i) {
				max = Math.max(1 + maxDepth(root.children.get(i)), max);
			}
			return max;
		}
		
	}
	
}
