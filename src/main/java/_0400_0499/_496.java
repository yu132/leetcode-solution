package _0400_0499;

import java.util.HashMap;
import java.util.Map;

public class _496 {
	
	class Solution {
		public int[] nextGreaterElement(int[] nums1, int[] nums2) {
			
			Map<Integer, Integer> map = new HashMap<>();
			
			int[] stack = new int[nums2.length];
			int len = 0;
			
			for (int i = 0; i < nums2.length; ++i) {
				
				while (len != 0 && nums2[i] > stack[len - 1]) {
					map.put(stack[--len], nums2[i]);
				}
				
				stack[len++] = nums2[i];
			}
			
			int[] ans = new int[nums1.length];
			
			for (int i = 0; i < nums1.length; ++i) {
				ans[i] = map.getOrDefault(nums1[i], -1);
			}
			
			return ans;
		}
	}
	
}
