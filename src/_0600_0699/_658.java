package _0600_0699;

import java.util.ArrayList;
import java.util.List;

public class _658 {

	class Solution {
		public List<Integer> findClosestElements(int[] arr, int k, int x) {
			List<Integer> list = new ArrayList<>();

			int low = 0, high = arr.length;

			while (low < high - 1) {
				int mid = (low + high) >>> 1;

				if (arr[mid] < x)
					low = mid;
				else if (arr[mid] > x)
					high = mid;
				else {
					low = mid;
					high = mid + 1;
				}
			}

			while (k > 0) {
				if (low < 0)
					++high;
				else if (high >= arr.length)
					--low;
				else {
					if (arr[high] - x < x - arr[low])
						++high;
					else
						--low;
				}
				--k;
			}

			for (int i = low + 1; i < high; ++i)
				list.add(arr[i]);

			return list;
		}
	}

}
