package old._0500_0599;

import java.util.ArrayList;
import java.util.List;

public class _589 {
	
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
		public void preorder(Node node, List<Integer> list) {
			if (node == null) {
				return;
			}
			list.add(node.val);
			for (int i = 0; i < node.children.size(); ++i) {
				preorder(node.children.get(i), list);
			}
		}
		
		public List<Integer> preorder(Node root) {
			List<Integer> list = new ArrayList<>();
			preorder(root, list);
			return list;
		}
	}
	
}
