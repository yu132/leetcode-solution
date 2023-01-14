package old._1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1200 {
	
	class Solution {
		public List<List<Integer>> minimumAbsDifference(int[] arr) {
			
			Arrays.sort(arr);
			
			long				diff	= Long.MAX_VALUE;
			
			List<List<Integer>>	list	= new ArrayList<>();
			
			for (int i = 1; i < arr.length; ++i) {
				if (arr[i] - arr[i - 1] < diff) {
					list.clear();
					diff = arr[i] - arr[i - 1];
					List<Integer> temp = new ArrayList<>();
					temp.add(arr[i - 1]);
					temp.add(arr[i]);
					list.add(temp);
				} else if (arr[i] - arr[i - 1] == diff) {
					List<Integer> temp = new ArrayList<>();
					temp.add(arr[i - 1]);
					temp.add(arr[i]);
					list.add(temp);
				}
			}
			
			return list;
		}
	}
	
}
