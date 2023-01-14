package old._0400_0499;

public class _443 {
	
	class Solution {
		
		public int compress(char[] chars) {
			if (chars.length == 0)
				return 0;
			
			char now = chars[0];
			int len = 1;
			
			int reWriteIndex = 0;
			
			for (int i = 1; i < chars.length; ++i) {
				if (chars[i] == now) {
					++len;
				} else {
					chars[reWriteIndex++] = now;
					if (len != 1) {
						for (char each : Integer.toString(len).toCharArray()) {
							chars[reWriteIndex++] = each;
						}
					}
					now = chars[i];
					len = 1;
				}
			}
			
			chars[reWriteIndex++] = now;
			if (len != 1) {
				for (char each : Integer.toString(len).toCharArray()) {
					chars[reWriteIndex++] = each;
				}
			}
			
			return reWriteIndex;
		}
	}
	
}
