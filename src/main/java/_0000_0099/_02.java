package _0000_0099;

import model.ListNode;

public class _02 {

/* v1
	  static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
		@Override
		public String toString() {
			StringBuilder sb=new StringBuilder();
			sb.append("{ ");
			 ListNode temp=this;
			while(temp!=null){
				if(temp==this)
					sb.append(val);
				else
					sb.append(" , ").append(temp.val);
				temp=temp.next;
			}
			sb.append(" }");
			return sb.toString();
		}
	  }


	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        StringBuilder sb=new StringBuilder();
	        while(l1!=null){
	            sb.append(l1.val);
	            l1=l1.next;
	        }
	        
	        BigInteger num1=new BigInteger(sb.reverse().toString());
	        
	       sb=new StringBuilder();
	        while(l2!=null){
	            sb.append(l2.val);
	            l2=l2.next;
	        }
	        
	        BigInteger num2=new BigInteger(sb.reverse().toString());
	        
	        BigInteger num3=num1.add(num2);
	        
	        String num3str=num3.toString();
	        
	        System.out.println(num3str);
	        
	        ListNode root=new ListNode(0);
	        ListNode temp=root;
	        
	        for(int i=num3str.length()-1;i>=0;i--){
	            temp.next=new ListNode(num3str.charAt(i)-'0');
	            temp=temp.next;
	        }
	        
	        return root.next;
	    }
	
	    public static void main(String[] args) {
	    	ListNode a=new ListNode(9);
	    	ListNode b=new ListNode(1);
	    	
	    	ListNode temp=b;
	    	for(int i=0;i<9;i++){
	    		temp.next=new ListNode(9);
	    		temp=temp.next;
	    	}
	    	
	    	ListNode ans=addTwoNumbers(a,b);
	    	while(ans!=null){
	    		System.out.println(ans.val);
	    		ans=ans.next;
	    	}
		}*/
	
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode head=new ListNode(0);
	    	
	    	ListNode now=head;
	    	
	    	int add1=0;
	    	
	    	while(l1!=null&&l2!=null){
	    		int value=l1.val+l2.val+add1;
	    		
	    		if(value>=10){
	    			add1=1;
	    			now.next=new ListNode(value-10);
	    		}else{
	    			add1=0;
	    			now.next=new ListNode(value);
	    		}
	    		l1=l1.next;
	    		l2=l2.next;
	    		now=now.next;
	    	}
	    	
	    	while(l1!=null){
	    		int value=l1.val+add1;
	    		
	    		if(value==10){
	    			add1=1;
	    			now.next=new ListNode(0);
	    		}else{
	    			add1=0;
	    			now.next=new ListNode(value);
	    		}
	    		l1=l1.next;
	    		now=now.next;
	    	}
	    	
	    	while(l2!=null){
	    		int value=l2.val+add1;
	    		
	    		if(value==10){
	    			add1=1;
	    			now.next=new ListNode(0);
	    		}else{
	    			add1=0;
	    			now.next=new ListNode(value);
	    		}
	    		l2=l2.next;
	    		now=now.next;
	    	}
	    	
	    	if(add1==1)
	    		now.next=new ListNode(1);
	    	
	    	return head.next;
	    }
	}
	
}
