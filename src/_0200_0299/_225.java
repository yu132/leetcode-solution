package _0200_0299;

import java.util.ArrayDeque;
import java.util.Queue;

public class _225 {

	class MyStack {
		
		private Queue<Integer> q1=new ArrayDeque<>();
		private Queue<Integer> q2=new ArrayDeque<>();
		
	    /** Initialize your data structure here. */
	    public MyStack() {}
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	    	q1.offer(x);
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
        	while(q1.size()!=1)
    			q2.offer(q1.poll());
	        
        	int ans=q1.poll();
        	
        	while(!q2.isEmpty())
    			q1.offer(q2.poll());
        	
	        return ans;
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	while(q1.size()!=1)
    			q2.offer(q1.poll());
	        
	    	int ans=q1.poll();
	    	
	    	q2.offer(ans);
	        
	        while(!q2.isEmpty())
    			q1.offer(q2.poll());
        	
	        return ans;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return q1.isEmpty();
	    }
	}
	
}
