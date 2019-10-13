package _400_499;

public class _459 {

	class Solution {
		public boolean repeatedSubstringPattern(String s) {

			//如果字串数量为二的倍数，那么总能拆成两份，无论可以细分成多少份，都无关紧要
			if (s.length() % 2 == 0) {
				boolean flag = true;
				for (int i = 0, mid = s.length() / 2; i < mid; ++i) {
					if (s.charAt(i) != s.charAt(mid + i)) {
						flag = false;
						break;
					}
				}
				if (flag == true)
					return true;
			}

			l: for (int i = 3, max = s.length(); i <= max; i += 2) {

				if (s.length() % i == 0) {

					int length = s.length() / i;

					for (int j = 0; j < length; ++j) {
						int loc = j;
						char c = s.charAt(loc);

						while ((loc += length) < s.length()) {
							if (c != s.charAt(loc))
								continue l;
						}
					}

					return true;
				}
			}

			return false;
		}
	}


	public static void main(String[] args) {
		System.out.println(new _459().new Solution().repeatedSubstringPattern("aaa"));
	}
}
