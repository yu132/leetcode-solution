package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;
import redo.Util.Bits;

/**  
 * @ClassName: P393  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P393 {

    class Solution {
        public boolean validUtf8(int[] data) {
            int index = 0;
            while (index < data.length) {
                int len = check(data, index);
                if (len == -1) {
                    return false;
                }
                index += len;
            }
            return true;
        }

        int check(int[] data, int start) {

            int len = unicodeLen(data[start]);

            if (len == -1) {
                return -1;
            } else if (len == 0) {
                return 1;
            } else if (len == 1) {
                return -1;
            }

            if (start + len > data.length) {
                return -1;
            }

            for (int i = start + 1; i < start + len; ++i) {
                if ((data[i] & 0x80) == 0) {
                    return -1;
                }
                if ((data[i] & 0x40) != 0) {
                    return -1;
                }
            }
            return len;
        }

        int unicodeLen(int firstByte) {

            int len = 0;

            for (int i = 7; i >= 0; --i) {
                if ((firstByte & (1 << i)) == 0) {
                    break;
                }
                ++len;
            }

            if (len > 4) {
                return -1;
            }

            return len;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(true, s.validUtf8(new int[] {197, 130, 1}));
        // System.out.println(Bits.toBinaryStr(145));
        Assert.assertEquals(true, s.validUtf8(new int[] {145}));

    }

}
