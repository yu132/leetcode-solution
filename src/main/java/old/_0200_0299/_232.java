package old._0200_0299;

import java.util.ArrayDeque;
import java.util.Deque;

public class _232 {

	class MyQueue {
		
		private Deque<Integer> stack1=new ArrayDeque<>();
		private Deque<Integer> stack2=new ArrayDeque<>();
		
	    /** Initialize your data structure here. */
	    public MyQueue() {}
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stack1.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        if(stack2.isEmpty()){
	        	while(!stack1.isEmpty()){
	        		stack2.push(stack1.pop());
	        	}
	        }
	        
	        return stack2.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	if(stack2.isEmpty()){
	        	while(!stack1.isEmpty()){
	        		stack2.push(stack1.pop());
	        	}
	        }
	        
	        return stack2.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack1.isEmpty()&&stack2.isEmpty();
	    }
	}
	
}
