package _1000_1099;

public class _1047 {
	
	class Solution {
		public String removeDuplicates(String S) {
			
			char[] stack = new char[S.length()];
			int length = 0;
			
			for (int i = 0; i < S.length(); ++i) {
				stack[length++] = S.charAt(i);
				if (length > 1) {
					if (stack[length - 1] == stack[length - 2])
						length -= 2;
				}
			}
			
			return String.copyValueOf(stack, 0, length);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new _1047().new Solution().removeDuplicates("aaaaa"));
	}
	
}
