package _1300_1399;

/**  
 * @ClassName: _1360  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月11日  
 *  
 */
public class _1360 {

    class Solution {
        public int daysBetweenDates(String date1, String date2) {
            return dayGap(Integer.valueOf(date1.substring(0, 4)), Integer.valueOf(date1.substring(5, 7)),
                Integer.valueOf(date1.substring(8, 10)), Integer.valueOf(date2.substring(0, 4)),
                Integer.valueOf(date2.substring(5, 7)), Integer.valueOf(date2.substring(8, 10)));
        }

        private int[] DAYS_OF_MONTH = {31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        private int[] DAYS_OF_FEBRUARY = {28, 29};

        public int dayGap(int yearA, int monthA, int dayA, int yearB, int monthB, int dayB) {
            int minYear = Math.min(yearA, yearB);
            return Math.abs(count(yearA, monthA, dayA, minYear) - count(yearB, monthB, dayB, minYear));
        }

        private int count(int year, int month, int day, int yearC) {
            if (year < yearC) {
                return 0;
            }
            int count = getDays(year, month, day);

            while (year > yearC) {
                --year;
                count += getDaysOfYear(year);
            }
            return count;
        }

        private int getDaysOfYear(int year) {
            return isLeapYear(year) ? 366 : 365;
        }

        private int getDays(int year, int month, int day) {
            int count = day;
            while (month != 1) {
                --month;
                if (month != 2) {
                    count += DAYS_OF_MONTH[month - 1];
                } else {
                    count += isLeapYear(year) ? DAYS_OF_FEBRUARY[1] : DAYS_OF_FEBRUARY[0];
                }
            }
            return count;
        }

        private boolean isLeapYear(int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }
    }

}
