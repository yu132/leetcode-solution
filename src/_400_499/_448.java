package _400_499;

import java.util.ArrayList;
import java.util.List;

public class _448 {
	
	class Solution {
		
		public void fill(int i, int n, int[] array) {
			if (array[i] == n) { return; }
			
			if (array[i] == -1) {
				array[i] = n;
				return;
			}
			
			int temp = array[i];
			array[i] = n;
			fill(temp - 1, temp, array);
		}
		
		public List<Integer> findDisappearedNumbers(int[] nums) {
			
			List<Integer> ans = new ArrayList<>();
			
			for (int i = 0; i < nums.length; ++i) {
				fill(i, -1, nums);
			}
			
			for (int i = 0; i < nums.length; ++i) {
				if (nums[i] != i + 1) {
					ans.add(i + 1);
				}
			}
			
			
			return ans;
		}
	}
	
	//	class Solution {
	//	    public List<Integer> findDisappearedNumbers(int[] nums) {
	//	        List<Integer> ret = new ArrayList<>();
	//	        int n = nums.length;
	//	        for (int i=0; i<n; i++) {
	//	            int index = (nums[i]-1) % n;
	//	            nums[index] += n;
	//	        }
	//	        for (int i=0; i<n; i++) {
	//	            if (nums[i] <= n) {
	//	                ret.add(i+1);
	//	            }
	//	        }
	//	        return ret;
	//	    }
	//	}
	
	
}
