package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1360  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1360 {

    static//

    class Solution {
        public int daysBetweenDates(String date1, String date2) {
            boolean d1min = date1.compareTo(date2) <= 0;
            String min = d1min ? date1 : date2, max = d1min ? date2 : date1;
            int day1 = dayOfYear(min), day2 = dayOfYear(max);
            int year1 = subDate(min, 0, 4), year2 = subDate(max, 0, 4);
            return daysBetweenYear(year1, year2) - day1 + day2;
        }

        private final static int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public static int daysBetweenYear(int year1, int year2) {
            int days = 0;
            for (int i = year1; i < year2; ++i) {
                days += isLeap(i) ? 366 : 365;
            }
            return days;
        }

        public static int dayOfYear(String date) {
            return dayOfYear(subDate(date, 0, 4), subDate(date, 5, 7), subDate(date, 8, 10));
        }

        private static int subDate(String date, int from, int to) {
            return Integer.valueOf(date.substring(from, to));
        }

        public static int dayOfYear(int year, int month, int day) {
            int days = 0;
            for (int i = 0; i < month - 1; ++i) {
                days += DAYS_OF_MONTH[i];
            }

            return days + day + (isLeap(year) && month > 2 ? 1 : 0);
        }

        public static boolean isLeap(int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.daysBetweenDates("2019-06-29", "2019-06-30"));
        Assert.assertEquals(15, s.daysBetweenDates("2020-01-15", "2019-12-31"));
        Assert.assertEquals(27949, s.daysBetweenDates("1943-06-23", "2019-12-30"));
    }

}
