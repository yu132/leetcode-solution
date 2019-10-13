package _500_599;

public class _520 {
	
	class Solution {
		public boolean detectCapitalUse(String word) {
			
			if (word.length() == 0) {
				return true;
			}
			
			char w0 = word.charAt(0);
			if (w0 >= 'a') {//首字母为小写，则全部为小写 
				
				for (int i = 1; i < word.length(); ++i) {
					if (word.charAt(i) <= 'Z') {
						return false;
					}
				}
				
			} else {//首字母为大写
				
				if (word.length() == 1)
					return true;
				
				char w1 = word.charAt(1);
				
				if (w1 >= 'a') {//第二字母为小写，则全部为小写 
					
					for (int i = 2; i < word.length(); ++i) {
						if (word.charAt(i) <= 'Z') {
							return false;
						}
					}
					
				} else {//第二字母为大写，则全部为大写 
					
					for (int i = 2; i < word.length(); ++i) {
						if (word.charAt(i) >= 'a') {
							return false;
						}
					}
				}
			}
			
			return true;
		}
	}
	
}
