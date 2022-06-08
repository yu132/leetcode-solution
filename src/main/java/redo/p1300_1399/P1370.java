package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1370  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1370 {

    class Solution {
        public String sortString(String s) {
            int[] count = countLowercaseLetters(s);
            StringBuilder buf = new StringBuilder(s.length());

            boolean up = true;
            int index = 0;
            while (buf.length() < s.length()) {
                if (count[index] != 0) {
                    buf.append((char)(index + 'a'));
                    --count[index];
                }
                if (up) {
                    ++index;
                } else {
                    --index;
                }
                if (index == 26) {
                    index = 25;
                    up = false;
                } else if (index == -1) {
                    index = 0;
                    up = true;
                }
            }

            return buf.toString();
        }

        public int[] countLowercaseLetters(String str) {
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                ++chs[ch - 'a'];
            }
            return chs;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("abccbaabccba", s.sortString("aaaabbbbcccc"));
        Assert.assertEquals("art", s.sortString("rat"));
        Assert.assertEquals("cdelotee", s.sortString("leetcode"));
        Assert.assertEquals("ggggggg", s.sortString("ggggggg"));
        Assert.assertEquals("ops", s.sortString("spo"));
    }
}
