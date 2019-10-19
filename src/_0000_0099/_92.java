package _0000_0099;

import model.ListNode;

public class _92 {

	class Solution {
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	    	
	    	ListNode temp=new ListNode(0);
	    	temp.next=head;

	    	head=temp;
	    	
	        int index=0;
	        ListNode node=head;
	        
	        temp=new ListNode(0);
	        temp.next=temp;
	        
	        while(index!=m-1){
	        	node=node.next;
	        	++index;
	        }
	        
	        ListNode end1=node;
	        
	        ListNode end2=node.next;
	        
	        while(index!=n+1){
	        	ListNode tempNode=node.next;
	        	node.next=end1.next;
	        	end1.next=node;
	        	node=tempNode;
	        	++index;
	        }
	        
	        end2.next=node;
	        
	        return head.next;
	    }
	}
	
}
