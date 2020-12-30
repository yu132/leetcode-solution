package redo.p0500_0599;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * @ClassName: P557  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P557 {

    class Solution {
        public String reverseWords(String s) {
            char[] chs = s.toCharArray();

            int start = -1;

            for (int i = 0; i < s.length(); ++i) {
                if (chs[i] == ' ') {
                    if (start != -1) {
                        reverse(chs, start, i);
                    }
                    start = -1;
                } else if (start == -1) {
                    start = i;
                }
            }
            if (start != -1) {
                reverse(chs, start, s.length());
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
        assertEquals("s'teL ekat edoCteeL tsetnoc", s.reverseWords("Let's take LeetCode contest"));
    }
}
