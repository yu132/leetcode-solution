package other.simple.linkedList;

import model.ListNode;

public class _5 {
	
	class Solution {
	    public boolean isPalindrome(ListNode head) {
	        
	    	int length=0;
	    	
	    	ListNode node=head;
	    	while(node!=null){
	    		length+=1;
	    		node=node.next;
	    	}
	    	
	    	if(length==1||length==0)
	    		return true;
	    	
	    	ListNode next=head;
	    	ListNode nextNext=next.next;
	    	next.next=null;
	    	
	    	for(int i=0;i<length/2-1;i++){
	    		ListNode thisNode=next;
	    		next=nextNext;
	    		nextNext=next.next;
	    		
	    		next.next=thisNode;
	    	}
	    	
	    	if(length%2!=0)
	    		nextNext=nextNext.next;
	    	
	    	while(next!=null&&nextNext!=null){
	    		if(next.val!=nextNext.val)
	    			return false;
	    		
	    		next=next.next;
	    		nextNext=nextNext.next;
	    	}
	    	
	    	return true;
	    }
	}
	
}
