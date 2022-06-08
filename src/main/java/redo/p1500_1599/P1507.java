package redo.p1500_1599;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1507  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1507 {

    static//

    class Solution {

        public final static Map<String, String> STR_MONTH_MAPPING;

        static {
            STR_MONTH_MAPPING = new HashMap<>();
            STR_MONTH_MAPPING.put("Jan", "01");
            STR_MONTH_MAPPING.put("Feb", "02");
            STR_MONTH_MAPPING.put("Mar", "03");
            STR_MONTH_MAPPING.put("Apr", "04");
            STR_MONTH_MAPPING.put("May", "05");
            STR_MONTH_MAPPING.put("Jun", "06");
            STR_MONTH_MAPPING.put("Jul", "07");
            STR_MONTH_MAPPING.put("Aug", "08");
            STR_MONTH_MAPPING.put("Sep", "09");
            STR_MONTH_MAPPING.put("Oct", "10");
            STR_MONTH_MAPPING.put("Nov", "11");
            STR_MONTH_MAPPING.put("Dec", "12");
        }

        public String reformatDate(String date) {
            if (Character.isLetter(date.charAt(1))) {
                return date.substring(8, 12) + "-" + STR_MONTH_MAPPING.get(date.substring(4, 7)) + "-0"
                    + date.charAt(0);
            } else {
                return date.substring(9, 13) + "-" + STR_MONTH_MAPPING.get(date.substring(5, 8)) + "-"
                    + date.substring(0, 2);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("2052-10-20", s.reformatDate("20th Oct 2052"));
        Assert.assertEquals("1933-06-06", s.reformatDate("6th Jun 1933"));
        Assert.assertEquals("1960-05-26", s.reformatDate("26th May 1960"));
    }

}
