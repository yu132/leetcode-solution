package _0300_0399;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _349 {

	class Solution {
	    public int[] intersection(int[] nums1, int[] nums2) {
	    	
	    	if(nums1.length==0||nums2.length==0)
	    		return new int[0];
	    	
	    	int[] longOne,shortOne;
	    	
	        if(nums1.length>nums2.length){
	        	longOne=nums1;
	        	shortOne=nums2;
	        }else{
	        	longOne=nums2;
	        	shortOne=nums1;
	        }
	        
	        Set<Integer> set=new HashSet<>(longOne.length);
	        
	        for(int i=0;i<longOne.length;i++)
	        	set.add(longOne[i]);
	        
	        int[] ans=new int[shortOne.length];
	        int index=0;
	        
	        for(int i=0;i<shortOne.length;i++)
	        	if(set.contains(shortOne[i])){
	        		set.remove(shortOne[i]);
	        		ans[index++]=shortOne[i];
	        	}
	        
	        return Arrays.copyOf(ans, index);
	    }
	}
	
}
