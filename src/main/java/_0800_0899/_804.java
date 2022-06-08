package _0800_0899;

import java.util.HashSet;
import java.util.Set;

public class _804 {
	
	class Solution {
		
		private String[] map = new String[] {
				".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
				"-..-", "-.--", "--.."
		};
		
		public int uniqueMorseRepresentations(String[] words) {
			Set<String> set = new HashSet<>();
			for (String word : words) {
				StringBuilder sb = new StringBuilder(word.length() * 4);
				for (char ch : word.toCharArray()) {
					sb.append(map[ch - 'a']);
				}
				set.add(sb.toString());
			}
			return set.size();
		}
	}
	
}
