package _0800_0899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class _811 {
	
	class Solution {
		public List<String> subdomainVisits(String[] cpdomains) {
			Map<String, Integer> counter = new HashMap<>(cpdomains.length * 3);
			
			for (String cpdomain : cpdomains) {
				String[]	sp		= cpdomain.split(" ");
				int			count	= Integer.valueOf(sp[0]);
				String[]	sp2		= sp[1].split(Pattern.quote("."));
				
				String		temp	= sp2[sp2.length - 1];
				counter.put(temp, counter.getOrDefault(temp, 0) + count);
				for (int i = sp2.length - 2; i >= 0; --i) {
					temp = sp2[i] + "." + temp;
					counter.put(temp, counter.getOrDefault(temp, 0) + count);
				}
			}
			
			List<String> ans = new ArrayList<>();
			for (Entry<String, Integer> entry : counter.entrySet()) {
				ans.add(entry.getValue() + " " + entry.getKey());
			}
			
			return ans;
		}
	}
	
}
