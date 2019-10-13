package _1000_1099;

import java.util.ArrayList;
import java.util.List;

public class _1078 {
	
	class Solution {
		public String[] findOcurrences(String text, String first, String second) {
			
			String[]		sp		= text.split(" ");
			
			boolean			c1		= false;
			boolean			c2		= false;
			
			List<String>	list	= new ArrayList<>();
			
			for (String each : sp) {
				if (c2) {
					list.add(each);
					c2 = false;
					if (each.equals(first)) {
						c1 = true;
					}
				} else if (c1) {
					if (each.equals(second)) {
						c2	= true;
						c1	= false;
					} else {
						c1 = false;
					}
				}
				if (each.equals(first)) {
					c1 = true;
				}
			}
			
			return list.toArray(new String[list.size()]);
		}
	}
	
}
