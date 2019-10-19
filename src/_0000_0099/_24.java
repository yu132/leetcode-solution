package _0000_0099;

import model.ListNode;

public class _24 {
	
	public ListNode swapPairs(ListNode head) {
        
		ListNode temp=new ListNode(0);
		
		ListNode root=temp;
		
		temp.next=head;
		
		while(temp.next!=null&&temp.next.next!=null){
			ListNode tempx=temp.next;
			temp.next=temp.next.next;
			tempx.next=temp.next.next;
			temp.next.next=tempx;
			temp=temp.next.next;
		}
		
		return root.next;
    }
	
}
