package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1052  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class P1052 {

    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {

            int satisfiedCount = 0;

            for (int i = 0; i < X; ++i) {
                satisfiedCount += customers[i];
            }

            for (int i = X; i < customers.length; ++i) {
                if (grumpy[i] == 0) {
                    satisfiedCount += customers[i];
                }
            }

            int max = satisfiedCount;

            for (int i = X, j = 0; i < customers.length; ++i, ++j) {
                if (grumpy[j] == 1) {
                    satisfiedCount -= customers[j];
                }
                if (grumpy[i] == 1) {
                    satisfiedCount += customers[i];
                }
                max = Math.max(max, satisfiedCount);
            }

            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(16,
            s.maxSatisfied(new int[] {1, 0, 1, 2, 1, 1, 7, 5}, new int[] {0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

}
