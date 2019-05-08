package other.simple.linkedList;

import model.ListNode;

public class _6 {

	public class Solution {
	    public boolean hasCycle(ListNode head) {
	    	if(head==null)
	    		return false;
	    	
	    	ListNode fast=head;
	    	ListNode slow=head;
	    	
	    	while(fast!=null&&fast.next!=null&&slow!=null){
	    		fast=fast.next.next;
	    		slow=slow.next;
	    		
	    		if(fast==slow)
	    			return true;
	    	}
	    	
	    	return false;
	    }
	}
	
}
