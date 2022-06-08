package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1154  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1154 {

    static

    class Solution {

        private final static int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int dayOfYear(String date) {
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
        Assert.assertEquals(9, s.dayOfYear("2019-01-09"));
        Assert.assertEquals(41, s.dayOfYear("2019-02-10"));
        Assert.assertEquals(60, s.dayOfYear("2019-03-01"));
        Assert.assertEquals(61, s.dayOfYear("2004-03-01"));
    }

}
