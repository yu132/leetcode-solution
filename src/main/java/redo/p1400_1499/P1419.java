package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1419  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1419 {

    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int[] count = new int[5];
            int max = 0;
            for (char ch : croakOfFrogs.toCharArray()) {
                switch (ch) {
                    case 'c':
                        ++count[0];
                        max = Math.max(max, count[0] - count[4]);
                        break;

                    case 'r':
                        if (plusAndCheck(count, 1)) {
                            return -1;
                        }
                        break;

                    case 'o':
                        if (plusAndCheck(count, 2)) {
                            return -1;
                        }
                        break;

                    case 'a':
                        if (plusAndCheck(count, 3)) {
                            return -1;
                        }
                        break;

                    case 'k':
                        if (plusAndCheck(count, 4)) {
                            return -1;
                        }
                        break;
                }
            }

            for (int i = 1; i < 5; ++i) {
                if (count[0] != count[i]) {
                    return -1;
                }
            }

            return max;
        }

        private boolean plusAndCheck(int[] count, int x) {
            ++count[x];
            for (int i = 0; i < x; ++i) {
                if (count[x] > count[i]) {
                    return true;
                }
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minNumberOfFrogs("croakcroak"));
        Assert.assertEquals(2, s.minNumberOfFrogs("crcoakroak"));
        Assert.assertEquals(-1, s.minNumberOfFrogs("croakcrook"));
        Assert.assertEquals(-1, s.minNumberOfFrogs("croakcroa"));
    }

}
