package old._0000_0099;

public class _42 {

	/**
	 * 其实就是短板效应，�?�是选取短的那一端作为能够装水的基准�?
	 * �?以从低到高很好计算，只需要判断一段比另一端高，然后按低的那端计算即可�?
	 * 
	 * 但是从某�?端开始遍历�?�是会遇�?   �?->�?->�?  这样的情况，那么我们只需要在高的那个�?
	 * 停止遍历即可，可是我们并不知道什么时候会遇到�?高点，所以我们的第一次遍历需要从左遍历到�?�?
	 * 然后再从右遍历到�?高点即可，时间复杂度为O(2n)=O(n)，空间复杂度为O(1)�?
	 * 
	 * 那为�?么相等的时�?�也计算呢？是因为我们如果先计算了相等的，那么从右边遍历过来的时候就无需计算这部分了�?
	 * 可以减少时间的消耗，当然时间复杂度是不变的�??
	 * 
	 * @author 87663
	 *
	 */
	class Solution {
		
	    public int trap(int[] height) {
	    	
	    	if(height.length==0)
	    		return 0;
	    	
	    	int maxh=0,maxIndex=-1,blockArea=0,totalArea=0;
	    	
	    	for(int i=0;i<height.length;i++){
	    		if(height[i]>=maxh){
	    			totalArea+=maxh*(i-maxIndex-1)-blockArea;
	    			
	    			maxh=height[i];
	    			maxIndex=i;
	    			blockArea=0;
	    			
	    		}else
	    			blockArea+=height[i];
	    	}
	    	
	    	int maxh2=0,maxIndex2=height.length;
	    	blockArea=0;
	    	
	    	for(int i=height.length-1;i>=maxIndex;i--){
	    		if(height[i]>maxh2){
	    			totalArea+=maxh2*(maxIndex2-i-1)-blockArea;
	    			
	    			maxh2=height[i];
	    			maxIndex2=i;
	    			blockArea=0;
	    			
	    		}else
	    			blockArea+=height[i];
	    	}
	    	
	    	return totalArea;
	    }
	}
	
	/**
	 * [0,0,1000,100,10000,12,132,51,234,523,6,1,2,0]
	 * 
	 * [1000,1,224,2,3,41,2,123,654,23,0,0,123,543,1000]
	 * 
	 * [10,10,10,10,10,10,10]
	 * 
	 */
	
	
}
