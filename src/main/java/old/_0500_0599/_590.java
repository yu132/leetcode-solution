package old._0500_0599;

import java.util.ArrayList;
import java.util.List;

public class _590 {
	
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
		
		private List<Integer> list = new ArrayList<>();
		
		public List<Integer> postorder(Node root) {
			
			if (root != null) {
				for (Node node : root.children) {
					postorder(node);
				}
				list.add(root.val);
			}
			
			return list;
			
		}
	}
	
}
