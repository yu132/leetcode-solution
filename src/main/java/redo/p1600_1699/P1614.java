package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1614  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1614 {

    class Solution {
        public int maxDepth(String s) {
            int depth = 0, max = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    ++depth;
                    max = Math.max(max, depth);
                } else if (ch == ')') {
                    --depth;
                }
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.maxDepth("(1+(2*3)+((8)/4))+1"));
        Assert.assertEquals(3, s.maxDepth("(1)+((2))+(((3)))"));
        Assert.assertEquals(1, s.maxDepth("1+(2*3)/(2-1)"));
        Assert.assertEquals(0, s.maxDepth("1"));
    }

}
