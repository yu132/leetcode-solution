package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1189  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1189 {

    class Solution {
        public int maxNumberOfBalloons(String text) {
            int[] count = countLowercaseLetters(text);
            int min = Integer.MAX_VALUE;
            min = Math.min(min, count['b' - 'a']);
            min = Math.min(min, count['a' - 'a']);
            min = Math.min(min, count['l' - 'a'] / 2);
            min = Math.min(min, count['o' - 'a'] / 2);
            min = Math.min(min, count['n' - 'a']);
            return min;
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
        Assert.assertEquals(1, s.maxNumberOfBalloons("nlaebolko"));
        Assert.assertEquals(2, s.maxNumberOfBalloons("loonbalxballpoon"));
        Assert.assertEquals(0, s.maxNumberOfBalloons("leetcode"));
        Assert.assertEquals(0, s.maxNumberOfBalloons("ballon"));
    }

}
