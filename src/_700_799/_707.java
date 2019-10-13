package _700_799;

public class _707 {
	
	//	class MyLinkedList {
	//		
	//		class Node {
	//			int		val;
	//			Node	next;
	//			Node	before;
	//			
	//			public Node(int val, Node next, Node before) {
	//				super();
	//				this.val	= val;
	//				this.next	= next;
	//				this.before	= before;
	//			}
	//		}
	//		
	//		private Node	head;
	//		
	//		private int		size	= 0;
	//		
	//		/** Initialize your data structure here. */
	//		public MyLinkedList() {
	//			head		= new Node(0, null, null);
	//			head.next	= head;
	//			head.before	= head;
	//		}
	//		
	//		/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	//		public int get(int index) {
	//			if (index >= size) {
	//				return -1;
	//			}
	//			Node node = head;
	//			while (index >= 0) {
	//				--index;
	//				node = node.next;
	//			}
	//			return node.val;
	//		}
	//		
	//		/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	//		public void addAtHead(int val) {
	//			Node node = new Node(val, head.next, head);
	//			head.next.before	= node;
	//			head.next			= node;
	//			++size;
	//		}
	//		
	//		/** Append a node of value val to the last element of the linked list. */
	//		public void addAtTail(int val) {
	//			Node node = new Node(val, head, head.before);
	//			head.before.next	= node;
	//			head.before			= node;
	//			++size;
	//		}
	//		
	//		/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	//		public void addAtIndex(int index, int val) {
	//			if (index > size) {
	//				return;
	//			} else if (index == size) {
	//				addAtTail(val);
	//				return;
	//			} else {
	//				Node node = head;
	//				while (index > 0) {
	//					--index;
	//					node = node.next;
	//				}
	//				Node newNode = new Node(val, node.next, node);
	//				node.next.before	= newNode;
	//				node.next			= newNode;
	//			}
	//			++size;
	//		}
	//		
	//		/** Delete the index-th node in the linked list, if the index is valid. */
	//		public void deleteAtIndex(int index) {
	//			if (index >= size) {
	//				return;
	//			}
	//			Node node = head;
	//			while (index > 0) {
	//				--index;
	//				node = node.next;
	//			}
	//			node.next.before	= node.before;
	//			node.before.next	= node.next;
	//			--size;
	//		}
	//		
	//		public void show() {
	//			Node node = head.next;
	//			while (node != head) {
	//				System.out.print(node.val + " ");
	//				node = node.next;
	//			}
	//			System.out.println();
	//		}
	//	}
	//	
	//	public static void main(String[] args) {
	//		MyLinkedList l = new _707().new MyLinkedList();
	//		l.addAtHead(1);
	//		l.addAtIndex(1, 2);
	//		
	//		System.out.println(l.get(2));
	//	}
	
}
