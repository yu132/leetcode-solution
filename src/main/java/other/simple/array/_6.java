package other.simple.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _6 {
	class Solution {
	    public int[] intersect(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        
	        List<Integer> res=new ArrayList<>();
	        
	        for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
	        	if(nums1[i]==nums2[j]){
	        		res.add(nums1[i]);
	        		i++;
	        		j++;
	        	}else if(nums1[i]<nums2[j]){
	        		i++;
	        	}else{
	        		j++;
	        	}
	        }
	        
	        int[] res1=new int[res.size()];
	        
	        for(int i=0;i<res1.length;i++){
	        	res1[i]=res.get(i);
	        }
	        
	        return res1;
	    }
	}
}
