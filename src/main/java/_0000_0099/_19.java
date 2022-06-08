package _0000_0099;

import model.ListNode;

public class _19 {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		 
		int count=0;
		
		ListNode temp=new ListNode(0);
		temp.next=head;
		
		ListNode front=temp;
		
		ListNode back=head;
		
		while(back.next!=null){
			if(count++>=n)
				front=front.next;
			back=back.next;
		}
		front.next=front.next.next;
		 
		return temp.next;
	}

}
