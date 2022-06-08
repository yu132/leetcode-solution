package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P38  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P38 {

    class Solution {
        public String countAndSay(int n) {
            String num = "1";
            while (--n != 0) {
                StringBuilder sb = new StringBuilder(200);
                int count = 1;
                for (int i = 1; i < num.length(); ++i) {
                    if (num.charAt(i) != num.charAt(i - 1)) {
                        sb.append(count).append(num.charAt(i - 1));
                        count = 1;
                    } else {
                        ++count;
                    }
                }
                sb.append(count).append(num.charAt(num.length() - 1));
                num = sb.toString();
            }
            return num;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("1", s.countAndSay(1));
        assertEquals("11", s.countAndSay(2));
        assertEquals("21", s.countAndSay(3));
        assertEquals("1211", s.countAndSay(4));
        assertEquals("111221", s.countAndSay(5));
    }
}
