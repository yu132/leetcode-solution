package other.middle.linkedList;

import model.ListNode;

public class _3 {

	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    	if(headA==null||headB==null)
	    		return null;
	        
	    	ListNode nodeA=headA;
	    	
	    	int lengthA=1;
	    	
	    	while(nodeA.next!=null){
	    		nodeA=nodeA.next;
	    		lengthA++;
	    	}
	    	
	    	ListNode nodeB=headB;
	    	
	    	int lengthB=1;
	    	
	    	while(nodeB.next!=null){
	    		nodeB=nodeB.next;
	    		lengthB++;
	    	}
	    	
	    	System.out.println(lengthA+" "+lengthB);
	    	
	    	if(lengthA>=lengthB){
	    		int diff=lengthA-lengthB;
	    		while(diff!=0&&headA!=null){
	    			headA=headA.next;
	    			diff--;
	    		}
	    	}else{
	    		int diff=lengthB-lengthA;
	    		while(diff!=0&&headB!=null){
	    			headB=headB.next;
	    			diff--;
	    		}
	    	}
	    	
	    	while(headA!=null&&headB!=null){
	    		if(headA==headB)
	    			return headA;
	    		
	    		System.out.println(headA+" "+headB);
	    		
	    		headA=headA.next;
	    		headB=headB.next;
	    	}
	    	
	    	return null;
	    }
	}
	
}
