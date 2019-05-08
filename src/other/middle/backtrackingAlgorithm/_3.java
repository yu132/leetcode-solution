package other.middle.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _3 {

	class Solution {
		
		List<List<Integer>> ans;
		
	    public List<List<Integer>> permute(int[] nums) {
	        ans=new ArrayList<>((int)Math.pow(2, nums.length));
	        get(nums,0);
	        return ans;
	    }
	    
	    private void get(int[] nums,int index){
	    	if(index>=nums.length){
	    		List<Integer> list=new ArrayList<>();
	    		for(int i=0;i<nums.length;i++)
	    			list.add(nums[i]);
	    		
	    		ans.add(list);
	    		
	    		return;
	    	}
	    	
	    	for(int i=index;i<nums.length;i++){
	    		swap(nums,i,index);
	    		get(nums,index+1);
	    		swap(nums,i,index);
	    	}
	    }
	    
	    private void swap(int[] nums,int x,int y){
	    	int temp=nums[x];
	    	nums[x]=nums[y];
	    	nums[y]=temp;
	    }
	}
	
}
