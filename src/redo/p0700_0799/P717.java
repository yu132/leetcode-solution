package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P717  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P717 {

    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            for (int i = 0; i < bits.length; ++i) {
                if (i == bits.length - 1) {
                    return true;
                }

                if (bits[i] == 1) {
                    ++i;
                }
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isOneBitCharacter(new int[] {1, 0, 0}));
        Assert.assertEquals(false, s.isOneBitCharacter(new int[] {1, 1, 1, 0}));
    }

}
