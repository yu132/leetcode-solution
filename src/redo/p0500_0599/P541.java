package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P541  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P541 {

    class Solution {
        public String reverseStr(String s, int k) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < s.length(); i += 2 * k) {
                int start = i, end = i + k;
                reverse(chs, start, Math.min(s.length(), end));
            }
            return String.valueOf(chs);
        }

        public void reverse(char[] chs, int start, int end) {
            end = end - 1;
            while (start < end) {
                char ch = chs[start];
                chs[start] = chs[end];
                chs[end] = ch;
                ++start;
                --end;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("bacdfeg", s.reverseStr("abcdefg", 2));
    }

}
