package _800_899;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _819 {
	
	
	
	class Solution {
		
		final static String spliter = "[\\s|!|?|'|,|.|;]";
		
		public String mostCommonWord(String paragraph, String[] banned) {
			Set<String> banset = new HashSet<>((int) (banned.length / 0.75));
			for (String each : banned) {
				banset.add(each.toLowerCase());
			}
			
			String[]				sp		= paragraph.split(spliter);
			Map<String, Integer>	counter	= new HashMap<>(sp.length / 2);
			for (String each : sp) {
				if (each.equals("")) {
					continue;
				}
				each = each.toLowerCase();
				if (!banset.contains(each)) {
					counter.put(each, counter.getOrDefault(each, 0) + 1);
				}
			}
			
			int		max		= 0;
			String	maxS	= null;
			
			for (Entry<String, Integer> entry : counter.entrySet()) {
				if (entry.getValue() > max) {
					max		= entry.getValue();
					maxS	= entry.getKey();
				}
			}
			
			return maxS;
		}
		
	}
	
	//	public static void main(String[] args) {
	//		System.out.println(Arrays.toString("1 2!3?4'5,6;7.8".split(spliter)));
	//	}
	
}
