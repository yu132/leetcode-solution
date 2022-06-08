package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P868  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P868 {

    class Solution {
        public int binaryGap(int n) {
            int bit = Integer.lowestOneBit(n), bit1, max = 0;
            if (bit == 0) {
                return 0;
            }
            while (true) {
                n &= n - 1;
                bit1 = Integer.lowestOneBit(n);

                if (bit1 == 0) {
                    break;
                }
                int temp = bit1;

                while (bit != 0) {
                    bit >>>= 1;
                    bit1 >>>= 1;
                }

                max = Math.max(max, bit1);

                bit = temp;
            }

            int count = 0;
            while (max != 0) {
                max >>>= 1;
                ++count;
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.binaryGap(22));
        Assert.assertEquals(2, s.binaryGap(5));
        Assert.assertEquals(1, s.binaryGap(6));
        Assert.assertEquals(0, s.binaryGap(8));
        Assert.assertEquals(0, s.binaryGap(1));
    }

}
