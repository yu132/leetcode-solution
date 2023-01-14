package old._0600_0699;

public class _697 {

	class Solution {
		
	    public int findShortestSubArray(int[] nums) {
	    	
	    	//int maxNum=Arrays.stream(nums).max().getAsInt()+1;
	    	
	    	int maxNum=-1;
	    	for(int i=0;i<nums.length;i++){
	    		if(nums[i]>maxNum)
	    			maxNum=nums[i];
	    	}
	    	
	    	++maxNum;
	    	
	        int[] count=new int[maxNum];
	        int[] fIndex=new int[maxNum];
	        int[] bIndex=new int[maxNum];
	        
	        for(int i=0;i<nums.length;i++){
	        	int num=nums[i];
	        	
	        	++count[num];
	        	if(count[num]==1)
	        		fIndex[num]=i;
	        	bIndex[num]=i;
	        }
	        
	        int maxCount=-1;
	        int minLength=Integer.MAX_VALUE;
	        
	        for(int i=0;i<maxNum;i++){
	        	int len=bIndex[i]-fIndex[i]+1;
	        	if(count[i]==maxCount){
	        		if(len<minLength)
	        			minLength=len;
	        	}else if(count[i]>maxCount){
	        		maxCount=count[i];
	        		minLength=len;
	        	}
	        }
	        
	        return minLength;
	    }
	}
	
}
