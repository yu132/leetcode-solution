package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1400  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1400 {

    class Solution {
        public boolean canConstruct(String s, int k) {
            int[] count = countLowercaseLetters(s);
            int odd = 0;
            for (int num : count) {
                if (num % 2 != 0) {
                    ++odd;
                }
            }
            return odd <= k && s.length() >= k;
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
        Assert.assertEquals(true, s.canConstruct("annabelle", 2));
        Assert.assertEquals(false, s.canConstruct("leetcode", 3));
        Assert.assertEquals(true, s.canConstruct("true", 4));
        Assert.assertEquals(true, s.canConstruct("yzyzyzyzyzyzyzy", 2));
        Assert.assertEquals(false, s.canConstruct("cr", 7));
        Assert.assertEquals(true, s.canConstruct("aaa", 2));
        Assert.assertEquals(true, s.canConstruct("qlkzenwmmnpkopu", 15));
        Assert.assertEquals(false, s.canConstruct("putmeinatrouble", 16));

    }

}
