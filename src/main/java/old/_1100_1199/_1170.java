package old._1100_1199;

import java.util.Arrays;

public class _1170 {
	
	class Solution {
		
		public int upperBound(int[] array, int from, int size, int key) {
			int	first	= from, len = size - 1;
			int	half, middle;
			
			while (len > 0) {
				half	= len >> 1;
				middle	= first + half;
				if (array[middle] > key)     //��λ������key,�ڰ���last�����������в��ҡ�
					len = half;
				else {
					first	= middle + 1;    //��λ��С�ڵ���key,���Ұ�������в��ҡ�
					len		= len - half - 1;
				}
			}
			return first;
		}
		
		private int f(String str) {
			int[] count = new int[26];
			for (char each : str.toCharArray()) {
				++count[each - 'a'];
			}
			for (int each : count) {
				if (each != 0) {
					return each;
				}
			}
			return 0;
		}
		
		public int[] numSmallerByFrequency(String[] queries, String[] words) {
			
			int[] count = new int[words.length];
			
			for (int i = 0; i < words.length; ++i) {
				count[i] = f(words[i]);
			}
			
			Arrays.sort(count);
			
			int[] ans = new int[queries.length];
			
			for (int i = 0; i < queries.length; ++i) {
				int temp = f(queries[i]);
				if (temp > count[count.length - 1]) {
					ans[i] = 0;
				} else {
					ans[i] = count.length - upperBound(count, 0, count.length, temp);
				}
			}
			
			return ans;
		}
	}
	
	public static void main(String[] args) {
		new _1170().new Solution().numSmallerByFrequency(new String[] { "bbb", "cc" },
				new String[]
				{ "a", "aa", "aaa", "aaaa" });
	}
}
