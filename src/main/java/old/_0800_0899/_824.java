package old._0800_0899;

public class _824 {
	
	class Solution {
		
		private boolean isVowel(char c) {
			if (c >= 'a') {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					return true;
				}
			} else {
				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					return true;
				}
			}
			return false;
		}
		
		public String toGoatLatin(String S) {
			
			
			StringBuilder	sb				= new StringBuilder(S.length() + 1000);
			
			boolean			start			= true;
			boolean			notVowelStart	= false;
			char			notVowel		= 0;
			int				countAInMa		= 2;
			
			for (char c : S.toCharArray()) {
				if (start) {
					if (isVowel(c)) {
						sb.append(c);
						notVowelStart = false;
					} else {
						notVowelStart	= true;
						notVowel		= c;
					}
					start = false;
					continue;
				}
				if (c == ' ') {
					if (notVowelStart) {
						sb.append(notVowel);
					}
					sb.append('m');
					for (int i = 0; i < countAInMa; ++i) {
						sb.append('a');
					}
					sb.append(' ');
					
					start = true;
					++countAInMa;
				} else {
					sb.append(c);
				}
			}
			
			if (notVowelStart) {
				sb.append(notVowel);
			}
			sb.append('m');
			for (int i = 0; i < countAInMa; ++i) {
				sb.append('a');
			}
			
			return sb.toString();
		}
	}
	
}
