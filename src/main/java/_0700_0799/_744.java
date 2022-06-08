package _0700_0799;

public class _744 {
	
	//	class Solution {
	//		
	//		public char nextGreatestLetter(char[] letters, char target) {
	//			byte[]	count	= new byte[26];
	//			
	//			char	bigOne	= (char) (target == 'z' ? 'a' : target + 1);
	//			
	//			for (char each : letters) {
	//				if (each == bigOne) {
	//					return bigOne;
	//				}
	//				count[each - 'a'] = 1;
	//			}
	//			
	//			for (int i = bigOne - 'a' + 1; i < 26; ++i) {
	//				if (count[i] == 1) {
	//					return (char) ('a' + i);
	//				}
	//			}
	//			
	//			for (int i = 0; i < target - 'a'; ++i) {
	//				if (count[i] == 1) {
	//					return (char) ('a' + i);
	//				}
	//			}
	//			
	//			return 0;
	//		}
	//	}
	
	class Solution {
		
		public int upperBound(char[] array, int from, int to, char key) {
			int	first	= from, len = to - 1;
			int	half, middle;
			
			while (len > 0) {
				half	= len >> 1;
				middle	= first + half;
				if (array[middle] > key)     //中位数大于key,在包含last的左半边序列中查找。
					len = half;
				else {
					first	= middle + 1;    //中位数小于等于key,在右半边序列中查找。
					len		= len - half - 1;
				}
			}
			return first;
		}
		
		public char nextGreatestLetter(char[] letters, char target) {
			int ans = upperBound(letters, 0, letters.length, target);
			return letters[ans] <= target ? letters[0] : letters[ans];
		}
	}
	
	public static void main(String[] args) {
		new _744().new Solution().nextGreatestLetter(new char[] {
				'c', 'f', 'j'
		}, 'd');
	}
	
}
