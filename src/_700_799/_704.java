package _700_799;

import java.util.Arrays;

public class _704 {
	
	class Solution {
		public int search(int[] nums, int target) {
			int temp = Arrays.binarySearch(nums, target);
			return temp >= 0 ? temp : -1;
		}
	}
	
}
