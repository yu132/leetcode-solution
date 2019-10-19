package _0000_0099;

import model.ListNode;

public class _21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode head=new ListNode(0);
		
		ListNode temp=head;
		
		while(l1!=null&&l2!=null){
			if(l1.val==l2.val){
				temp.next=l1;
				temp=temp.next;
				l1=l1.next;
				
				temp.next=l2;
				temp=temp.next;
				l2=l2.next;
			}else if(l1.val>l2.val){
				temp.next=l2;
				temp=temp.next;
				l2=l2.next;
			}else{
				temp.next=l1;
				temp=temp.next;
				l1=l1.next;
			}
		}
		
		if(l1!=null)
			temp.next=l1;
		if(l2!=null)
			temp.next=l2;
		
		return head.next;
    }
	
}
