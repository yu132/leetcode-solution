package _900_999;

import java.util.Arrays;

public class _948 {

	class Solution {
		public int bagOfTokensScore(int[] tokens, int P) {
			Arrays.sort(tokens);

			if (tokens.length == 0 || P < tokens[0])
				return 0;

			int low = 0, high = tokens.length - 1, point = 0;
			while (high >= low) {
				if (P >= tokens[low]) {
					P -= tokens[low++];
					++point;
				} else
					P += tokens[high--] - tokens[low++];
			}

			return point;
		}
	}

}
