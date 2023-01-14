package old._0500_0599;

public class _558 {
	
	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;
		
		public Node() {}
		
		public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft,
				Node _bottomRight) {
			val = _val;
			isLeaf = _isLeaf;
			topLeft = _topLeft;
			topRight = _topRight;
			bottomLeft = _bottomLeft;
			bottomRight = _bottomRight;
		}
	};
	
	class Solution {
		
		public void combine(Node a) {
			if (a.isLeaf) {
				return;
			}
			
			if (a.topLeft.isLeaf && a.topRight.isLeaf && a.bottomLeft.isLeaf
					&& a.bottomRight.isLeaf) {
				
				if (a.topLeft.val == a.topRight.val && a.topLeft.val == a.bottomLeft.val
						&& a.topLeft.val == a.bottomRight.val) {
					a.isLeaf = true;
					a.val = a.topLeft.val;
				}
			}
		}
		
		public Node level(Node a, Node b) {
			if (a.isLeaf) {
				if (a.val) {
					Node c = new Node(true, true, null, null, null, null);
					return c;
				} else {
					return b;
				}
			}
			
			if (b.isLeaf) {
				if (b.val) {
					Node c = new Node(true, true, null, null, null, null);
					return c;
				} else {
					return a;
				}
			}
			
			Node c = new Node(false, false, level(a.topLeft, b.topLeft),
					level(a.topRight, b.topRight), level(a.bottomLeft, b.bottomLeft),
					level(a.bottomRight, b.bottomRight));
			
			combine(c);
			
			return c;
		}
		
		public Node intersect(Node quadTree1, Node quadTree2) {
			return level(quadTree1, quadTree2);
		}
	}
	
}
