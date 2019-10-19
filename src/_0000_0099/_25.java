package _0000_0099;

import model.ListNode;

public class _25 {

	class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	    	
	    	if(k<=1)
	    		return head;
	    	
	    	ListNode temp=new ListNode(0);
	    	
	    	ListNode node=head;
	    	
	    	ListNode first=temp;
	    	ListNode next;
	    	int count=0;
	    	
	    	while(node!=null){
	    		
	    		System.out.println(node.val);
	    		
	    		++count;
	    		
	    		next=node.next;
	    		
	    		node.next=first.next;
	    		first.next=node;
	    		
	    		if(count==k)
	    			while(first.next!=null){
	    				first=first.next;
	    				--count;
	    			}
	    		
	    		node=next;
	    	}
	    	
	    	System.out.println(first.val);
	    	
	    	if(count>1&&count<k){
	    		node=first.next;
	    		first.next=null;
	    		
	    		while(node!=null){
	    			next=node.next;
	    			
	    			node.next=first.next;
		    		first.next=node;
		    		
		    		node=next;
	    		}
	    	}
	    	
	    	return temp.next;
	    }
	}
	
}
