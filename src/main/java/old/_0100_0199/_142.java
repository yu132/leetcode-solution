package old._0100_0199;

import model.ListNode;

public class _142 {

	public class Solution {
	    public ListNode detectCycle(ListNode head) {
            if(head==null)
    	    	return null;
            
            ListNode fast=head;
            ListNode slow=head;

            boolean cycle=false;
            
            while(fast!=null&&fast.next!=null&&slow!=null){
                fast=fast.next.next;
                slow=slow.next;

                if(fast==slow){
                	cycle=true;
                	
                	while(head!=slow){
                		head=head.next;
                		slow=slow.next;
                	}
                	
                	break;
                }
            }

            return cycle?head:null;
	    }
	}
	
}
