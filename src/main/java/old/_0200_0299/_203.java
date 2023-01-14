package old._0200_0299;

import model.ListNode;

public class _203 {

	class Solution {
		
	    public ListNode removeElements(ListNode head, int val) {
	    	
	    	if(head==null)
	    		return null;
	    	
	    	while(head!=null&&head.val==val){
	    		head=head.next;
	    	}
	    	
	    	ListNode temp=head;
	    	
	    	while(temp!=null&&temp.next!=null){
	    		if(temp.next.val==val)
	    			temp.next=temp.next.next;
	    		else
	    			temp=temp.next;
	    	}
	    	
	    	return head;
	    }
	    
	}
	
}
