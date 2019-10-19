package _0400_0499;

import java.util.Arrays;

public class _493 {

	class Solution {
		
		int[] temp;
		
	    public int reversePairs(int[] nums) {
	    	
	    	if(nums.length==0)
	    		return 0;
	    	
	    	temp=new int[nums.length];
	    	
	    	int ans=merge(nums, 0, nums.length-1);
	    	
	    	System.out.println(Arrays.toString(nums));
	    	
	        return ans;
	    }
	    
	    public int merge(int[] nums,int l,int r){
	    	if(l==r)
	    		return 0;
	    	
	    	int mid=(l+r)>>>1;
	    	
	    	int lcount=merge(nums,l,mid);
	    	int rcount=merge(nums,mid+1,r);
	    	
	    	int total=lcount+rcount;
	    	
	    	int i1=l,j=mid+1;
	    	while(j<=r){
	    		while(i1<=mid&&(double)nums[i1]/2<=nums[j])
	    			i1++;
	    		total+=mid-i1+1;
	    		j++;
	    	}
	    	
	    	int lIndex=l,rIndex=mid+1;
	    	
	    	for(int i=l;i<=r;i++){
	    		if(lIndex==mid+1){
	    			temp[i]=nums[rIndex++];
	    		}else if(rIndex==r+1){
	    			temp[i]=nums[lIndex++];
	    		}else{
	    			if(nums[lIndex]<=nums[rIndex])
	    				temp[i]=nums[lIndex++];
	    			else
	    				temp[i]=nums[rIndex++];
	    		}
	    	}
	    	
	    	System.arraycopy(temp, l, nums, l, r-l+1);
	    	
	    	return total;
	    }
	}
}
