package old._1100_1199;

public class _1185 {
	
	class Solution {
		
		private String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };
		
		public int dayOfWeek(int year, int month, int day) {
			if (month == 1 || month == 2) {//һ���»���
				month += 12;
				year--;
			}
			int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100
					+ year / 400 + 1) % 7;
			return week;
		}
		
		public String dayOfTheWeek(int day, int month, int year) {
			return dayOfWeek[dayOfWeek(year, month, day)];
		}
	}
}
