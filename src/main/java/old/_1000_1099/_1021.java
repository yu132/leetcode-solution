package old._1000_1099;

public class _1021 {
	
	class Solution {
		public String removeOuterParentheses(String S) {
			
			int				lc	= 0;
			
			StringBuilder	sb	= new StringBuilder(S.length());
			
			for (char each : S.toCharArray()) {
				if (each == '(') {
					++lc;
					if (lc != 1) {
						sb.append('(');
					}
				} else {//each == ')'
					--lc;
					if (lc != 0) {
						sb.append(')');
					}
				}
			}
			
			return sb.toString();
		}
	}
	
}
