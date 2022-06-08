package other.middle.linkedList;

import model.ListNode;

public class _2 {

	class Solution {
	    public ListNode oddEvenList(ListNode head) {
	    	ListNode odd=new ListNode(0);//奇数
	    	ListNode oddNowNode=odd;
	    	
	    	
	    	ListNode even=new ListNode(0);//偶数
	    	ListNode evenNowNode=even;
	    	
	    	int count=1;
	    	
	    	while(head!=null){
	    		if(count%2==1){//j奇数
	    			oddNowNode.next=head;
	    			oddNowNode=oddNowNode.next;
	    		}else{//偶数
	    			evenNowNode.next=head;
	    			evenNowNode=evenNowNode.next;
	    		}
	    		head=head.next;
	    		count++;
	    	}
	    	
	    	oddNowNode.next=even.next;
	    	
	    	evenNowNode.next=null;
	    	
	    	return odd.next;
	    }
	}
	
}
