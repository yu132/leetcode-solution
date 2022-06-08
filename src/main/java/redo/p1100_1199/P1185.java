package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1185  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1185 {

    static//

    class Solution {

        private final static String[] STR =
            {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        public String dayOfTheWeek(int day, int month, int year) {
            return STR[dayOfWeek(year, month, day)];
        }

        public int dayOfWeek(int year, int month, int day) {
            if (month == 1 || month == 2) {// 一二月换算
                month += 12;
                year--;
            }
            int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7;
            return week;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("Saturday", s.dayOfTheWeek(31, 8, 2019));
        Assert.assertEquals("Sunday", s.dayOfTheWeek(18, 7, 1999));
        Assert.assertEquals("Sunday", s.dayOfTheWeek(15, 8, 1993));
    }
}
