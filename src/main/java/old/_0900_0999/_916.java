package old._0900_0999;

import java.util.ArrayList;
import java.util.List;

public class _916 {

	class Solution {
		public List<String> wordSubsets(String[] A, String[] B) {

			List<String> ans = new ArrayList<>();

			int[] Bcount = new int[26];

			for (int i = 0; i < B.length; ++i) {
				int[] BcountTemp = new int[26];
				for (int j = 0; j < B[i].length(); ++j) {
					++BcountTemp[B[i].charAt(j) - 'a'];
				}

				for (int j = 0; j < 26; ++j) {
					if (BcountTemp[j] > Bcount[j])
						Bcount[j] = BcountTemp[j];
				}
			}

			l: for (int i = 0; i < A.length; ++i) {
				int[] Acount = new int[26];

				for (int j = 0; j < A[i].length(); ++j)
					++Acount[A[i].charAt(j) - 'a'];

				for (int j = 0; j < 26; ++j)
					if (Acount[j] < Bcount[j])
						continue l;

				ans.add(A[i]);
			}

			return ans;
		}
	}

}
