package other.middle.sortAndSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Interval;

public class _6 {

	class Solution {
	    public List<Interval> merge(List<Interval> intervals) {
	    	
	    	if(intervals.size()==0)
	    		return intervals;
	    	
	        Collections.sort(intervals,new Comparator<Interval>(){
				@Override
				public int compare(Interval o1, Interval o2) {
					int dif=o1.start-o2.start;
					
					if(dif!=0)
						return dif;
					
					return o1.end-o2.end;
				}
	        });
	        
	        List<Interval> intervalsNew=new ArrayList<>();
	        
	        for(int i=0;i<intervals.size()-1;i++){
	        	Interval f=intervals.get(i);
	        	
	        	Interval b=intervals.get(i+1);
	        	
	        	if(f.end>=b.start){
	        		b.start=f.start;
	        		
	        		if(f.end>b.end)
	        			b.end=f.end;
	        	}else{
	        		intervalsNew.add(new Interval(f.start,f.end));
	        	}
	        }
	        
	        Interval last=intervals.get(intervals.size()-1);
	        
	        intervalsNew.add(new Interval(last.start,last.end));
	        
	        return intervalsNew;
	    }
	}
	
}
