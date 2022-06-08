package other.middle.sortAndSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _2 {

	class Solution {
	    public List<Integer> topKFrequent(int[] nums, int k) {
	        Map<Integer,Integer> map=new HashMap<>();
	        
	        for(int i=0;i<nums.length;i++){
	        	Integer count=map.get(nums[i]);
	        	
	        	if(count==null){
	        		map.put(nums[i], 0);
	        	}else{
	        		map.put(nums[i], count+1);
	        	}
	        }
	        
	        List<Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
	        
	        Collections.sort(list,new Comparator<Entry<Integer,Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					return o2.getValue()-o1.getValue();
				}
			});
	        
	        List<Integer> ans=new ArrayList<>();
	        
	        for(int i=0;i<k;i++){
	        	ans.add(list.get(i).getKey());
	        }
	        
	        return ans;
	    }
	}
	
}
