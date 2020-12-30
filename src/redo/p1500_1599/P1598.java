package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1598  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1598 {

    class Solution {
        public int minOperations(String[] logs) {
            int level = 0;
            for (String op : logs) {
                if (op.charAt(0) == '.') {
                    if (op.charAt(1) == '.') {
                        if (level != 0) {
                            --level;
                        }
                    }
                } else {
                    ++level;
                }
            }
            return level;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minOperations(new String[] {"d1/", "d2/", "../", "d21/", "./"}));
        Assert.assertEquals(3, s.minOperations(new String[] {"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        Assert.assertEquals(0, s.minOperations(new String[] {"d1/", "../", "../", "../"}));
    }

}
