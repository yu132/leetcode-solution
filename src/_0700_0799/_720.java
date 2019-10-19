package _0700_0799;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _720 {
	
	//	class Solution {
	//		public String longestWord(String[] words) {
	//			
	//			Arrays.sort(words, (str1, str2) -> {
	//				if (str1.length() != str2.length()) {
	//					return Integer.compare(str1.length(), str2.length());
	//				} else {
	//					return str2.compareTo(str1);
	//				}
	//			});
	//			
	//			Set<String> set = new HashSet<>(words.length);
	//			
	//			set.add("");
	//			
	//			String	ans		= null;
	//			
	//			for (String each : words) {
	//				String before = each.substring(0, each.length() - 1);
	//				if (set.contains(before)) {
	//					set.add(each);
	//					ans=each;
	//				}
	//			}
	//			
	//			return ans;
	//		}
	//	}
	
	class Solution {
		
		public boolean check(String word, Set<String> set) {
			if (!set.contains(word)) {
				return false;
			}
			if (word.length() == 1) {
				return true;
			} else {
				return check(word.substring(0, word.length() - 1), set);
			}
		}
		
		public String longestWord(String[] words) {
			Set<String> set = new HashSet<>();
			
			for (String each : words) {
				set.add(each);
			}
			
			Arrays.sort(words, (str1, str2) -> {
				if (str1.length() != str2.length()) {
					return Integer.compare(str2.length(), str1.length());
				} else {
					return str1.compareTo(str2);
				}
			});
			
			for (String each : words) {
				if (check(each, set)) {
					return each;
				}
			}
			
			return "";
		}
	}
	
}
