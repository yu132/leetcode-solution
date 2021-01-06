package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1653  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1653 {

    class Solution {
        public int minimumDeletions(String s) {
            int aL = 0, aR = 0, bL = 0, bR = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'a') {
                    ++aR;
                } else {
                    ++bR;
                }
            }
            int min = Math.min(aR + bL, aL + bR);
            for (char ch : s.toCharArray()) {
                if (ch == 'a') {
                    --aR;
                    ++aL;
                } else {
                    --bR;
                    ++bL;
                }
                min = Math.min(min, aR + bL);
            }
            return min;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minimumDeletions("aababbab"));
        Assert.assertEquals(2, s.minimumDeletions("bbaaaaabb"));
        Assert.assertEquals(41, s.minimumDeletions(
            "aabbaababbababaabbbaabbbbaababababbabbbababbabbaabaaabbbbbbaaabbbbabaababbaaabbbbaaabababbbaaa"));
    }

}
