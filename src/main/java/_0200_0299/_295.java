package _0200_0299;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _295 {

	class MedianFinder {
		
		private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

	    /** initialize your data structure here. */
	    public MedianFinder() {}
	    
	    public void addNum(int num) {
	        if(num<findMedian())
	        	maxHeap.add(num);
	        else
	        	minHeap.add(num);
	        
	        if(maxHeap.size()>minHeap.size())
	        	minHeap.add(maxHeap.poll());
	        else if(minHeap.size()-maxHeap.size()>1)
	        	maxHeap.add(minHeap.poll());
	    }
	    
	    public double findMedian() {
	        if(maxHeap.isEmpty()&&minHeap.isEmpty())
	        	return 0;
	        if(maxHeap.size()==minHeap.size())
	        	return (maxHeap.peek()+minHeap.peek())/2.0;
	        return minHeap.peek();
	    }
	}
}
