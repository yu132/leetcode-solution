package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P171  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P171 {

    class Solution {
        public int titleToNumber(String s) {
            int num = 0;
            for (char ch : s.toCharArray()) {
                num = num * 26 + ch - 'A' + 1;
            }
            return num;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(1, s.titleToNumber("A"));
        assertEquals(28, s.titleToNumber("AB"));
        assertEquals(701, s.titleToNumber("ZY"));
    }

}
