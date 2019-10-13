package _800_899;

import model.ListNode;

public class _876 {
	
	class Solution {
		public ListNode middleNode(ListNode head) {
			
			if (head == null) {
				return null;
			} else if (head.next == null) {
				return head;
			}
			
			ListNode	fast	= head;
			ListNode	slow	= head;
			
			while (fast.next != null) {
				if (fast.next.next != null) {
					fast = fast.next.next;
				} else {
					fast = fast.next;
				}
				slow = slow.next;
			}
			
			return slow;
		}
	}
	
}
