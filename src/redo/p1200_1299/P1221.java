package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1221  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1221 {

    class Solution {
        public int balancedStringSplit(String s) {

            int count = 0, ans = 0;

            for (char ch : s.toCharArray()) {
                if (ch == 'R') {
                    ++count;
                } else {
                    --count;
                }
                if (count == 0) {
                    ++ans;
                }
            }

            return ans;

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.balancedStringSplit("RLRRLLRLRL"));
        Assert.assertEquals(3, s.balancedStringSplit("RLLLLRRRLR"));
        Assert.assertEquals(1, s.balancedStringSplit("LLLLRRRR"));
    }
}
