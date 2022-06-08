package _1100_1199;

public class _1154 {
	
	class Solution {
		
		int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		private boolean isLeap(int year) {
			return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
		}
		
		public int dayOfYear(String date) {
			int	year	= 0;
			int	month	= 0;
			int	day		= 0;
			
			int	c_		= 0;
			
			for (char each : date.toCharArray()) {
				if (each == '-') {
					++c_;
					continue;
				}
				if (c_ == 0) {
					year = year * 10 + (each - '0');
				} else if (c_ == 1) {
					month = month * 10 + (each - '0');
				} else {
					day = day * 10 + (each - '0');
				}
			}
			
			int count = 0;
			for (int i = 0; i < month - 1; ++i) {
				count += days[i];
			}
			
			return count + day + (month > 2 && isLeap(year) ? 1 : 0);
		}
	}
	
}
