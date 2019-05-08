package other.simple.linkedList;

import model.ListNode;

public class _1 {

	class Solution {
	    public void deleteNode(ListNode node) {
	        node.val=node.next.val;
	        node.next=node.next.next;
	    }
	}
}
