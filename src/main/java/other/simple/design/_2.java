package other.simple.design;

import java.util.ArrayList;
import java.util.List;

public class _2 {

	class MinStack {
		
		private List<Integer> main=new ArrayList<>();
		
		private List<Integer> assist=new ArrayList<>();

	    /** initialize your data structure here. */
	    public MinStack() {}
	    
	    public void push(int x) {
	    	main.add(x);
	    	
	    	if(main.size()==1)
	    		assist.add(0);
	    	else
		    	if(x<main.get(assist.get(assist.size()-1)))
		    		assist.add(main.size()-1);
	    }
	    
	    public void pop() {
	    	if(main.size()-1==assist.get(assist.size()-1))
	    		assist.remove(assist.size()-1);
	        main.remove(main.size()-1);
	    }
	    
	    public int top() {
	        return main.get(main.size()-1);
	    }
	    
	    public int getMin() {
	        return main.get(assist.get(assist.size()-1));
	    }
	}
	
}
