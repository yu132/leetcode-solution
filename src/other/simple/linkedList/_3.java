package other.simple.linkedList;

import model.ListNode;

public class _3 {

	class Solution {
	    public ListNode reverseList(ListNode head) {
	        if(head==null)
	        	return null;
	        
	        ListNode node=new ListNode(head.val);
	        while(head.next!=null){
	        	head=head.next;
	        	ListNode newNode=new ListNode(head.val);
	        	newNode.next=node;
	        	node=newNode;
	        }
	        
	        return node;
	    }
	}
	
}
