package _0300_0399;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _341 {
	

	  // This is the interface that allows for creating nested lists.
	  // You should not implement it, or speculate about its implementation
	  public interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
	 
	

	public class NestedIterator implements Iterator<Integer> {

		private List<Integer> intList=new ArrayList<>();
		
		private int index=0;
		
	    public NestedIterator(List<NestedInteger> nestedList) {
	        dfs(nestedList);
	    }
	    
	    public void dfs(List<NestedInteger> nestedList){
	    	for(int i=0;i<nestedList.size();i++){
	    		NestedInteger ele=nestedList.get(i);
	    		if(ele.isInteger())
	    			intList.add(ele.getInteger());
	    		else
	    			dfs(ele.getList());
	    	}
	    }

	    @Override
	    public Integer next() {
	        return intList.get(index++);
	    }

	    @Override
	    public boolean hasNext() {
	    	return index<intList.size();
	    }
	}
}
