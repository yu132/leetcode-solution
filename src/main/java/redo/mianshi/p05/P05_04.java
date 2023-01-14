package redo.mianshi.p05;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P05_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P05_04 {

    // 00000100000111
    // 00000011110000

    // 0010
    // 0001

    class Solution {
        public int[] findClosedNumbers(int num) {
            int mask = 1, count1 = 0, ans[] = {-1, -1}, copy = num;

            for (int i = 0; i < 31 && (ans[0] == -1 || ans[1] == -1);
                ++i, num &= ~mask, mask <<= 1) {

                if ((copy & mask) != 0) {
                    if (ans[0] == -1 && (copy & (mask << 1)) == 0) {
                        int s1 = (1 << count1) - 1;
                        ans[0] = num & ~mask | (mask << 1) | s1;
                    }
                    if (ans[1] == -1 && (mask >> 1) != 0
                        && (copy & (mask >> 1)) == 0) {
                        int s1 = i - 1 - count1 >= 0
                            ? ((1 << count1) - 1) << (i - 1 - count1) : 0;
                        ans[1] = num & ~mask | (mask >> 1) | s1;
                    }
                    ++count1;
                }
            }

            if (ans[0] < num) {
                ans[0] = -1;
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {66, 48}, s.findClosedNumbers(65));
        Assert.assertArrayEquals(new int[] {234865691, 234865679},
            s.findClosedNumbers(234865687));
    }

}
