package _700_799;

public class _709 {
	
	class Solution {
		public String toLowerCase(String str) {
			int		dif	= 'a' - 'A';
			char[]	ch	= str.toCharArray();
			for (int i = 0; i < ch.length; ++i) {
				if (ch[i] >= 'A' && ch[i] <= 'Z') {
					ch[i] += dif;
				}
			}
			return new String(ch);
		}
	}
	
}
