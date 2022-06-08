package _0800_0899;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _884 {
	
	class Solution {
		public String[] uncommonFromSentences(String A, String B) {
			
			String[]		spA		= A.split(" ");
			String[]		spB		= B.split(" ");
			
			Set<String>		setA	= new HashSet<>();
			Set<String>		setB	= new HashSet<>();
			Set<String>		setMore	= new HashSet<>();
			
			List<String>	less	= new ArrayList<>();
			
			for (String each : spA) {
				if (setA.contains(each)) {
					setMore.add(each);
				} else {
					setA.add(each);
				}
			}
			for (String each : spB) {
				if (setA.contains(each)) {
					setMore.add(each);
				} else {
					setA.add(each);
				}
			}
			
			for (String each : setA) {
				if (!setMore.contains(each) && !setB.contains(each)) {
					less.add(each);
				}
			}
			for (String each : setB) {
				if (!setMore.contains(each) && !setA.contains(each)) {
					less.add(each);
				}
			}
			
			return less.toArray(new String[less.size()]);
		}
	}
	
}
