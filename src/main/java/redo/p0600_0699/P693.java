package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P693  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P693 {

    class Solution {
        public boolean hasAlternatingBits(int n) {
            int mask = getMask(n);
            return (mask & (n ^ 0xAAAAAAAA)) == 0 || (mask & (n ^ 0x55555555)) == 0;
        }

        public int getMask(int num) {
            num |= num >>> 1;
            num |= num >>> 2;
            num |= num >>> 4;
            num |= num >>> 8;
            num |= num >>> 16;
            return num;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.hasAlternatingBits(5));
        Assert.assertEquals(false, s.hasAlternatingBits(7));
        Assert.assertEquals(false, s.hasAlternatingBits(11));
        Assert.assertEquals(true, s.hasAlternatingBits(10));
        Assert.assertEquals(false, s.hasAlternatingBits(4));
    }

}
