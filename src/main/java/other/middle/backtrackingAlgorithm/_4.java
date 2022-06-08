package other.middle.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class _4 {

	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	    	List<List<Integer>> ans=new ArrayList<>();
	    	if(nums.length==0)
	    		return ans;
	    	
	    	backtracking(ans,new ArrayList<>(),nums,0);
	    	
	    	return ans;
	    }
	    
	    public void backtracking(List<List<Integer>> ans,
	    		List<Integer> temp,int[] nums,int index){
	    	ans.add(new ArrayList<>(temp));
	    	
	    	for(int i=index;i<nums.length;i++){
	    		temp.add(nums[i]);
	    		backtracking(ans,temp,nums,i+1);
	    		temp.remove(temp.size()-1);
	    	}
	    }
	}
	
}
