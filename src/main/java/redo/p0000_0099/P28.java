package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P28  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P28 {

    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.equals("")) {
                return 0;
            }
            for (int start = 0; start < haystack.length() - needle.length() + 1; ++start) {
                boolean flag = true;
                for (int i = 0; i < needle.length(); ++i) {
                    if (haystack.charAt(start + i) != needle.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return start;
                }
            }
            return -1;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(-1, s.strStr("aaaaa", "bba"));
        assertEquals(2, s.strStr("hello", "ll"));
        assertEquals(-1, s.strStr("123456", "567"));
        assertEquals(0, s.strStr("123456", ""));
        assertEquals(0, s.strStr("123456", "123"));
        assertEquals(0, s.strStr("1", "1"));
        assertEquals(3, s.strStr("123456", "456"));
    }

}
