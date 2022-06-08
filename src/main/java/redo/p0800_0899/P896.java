package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P896  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月23日  
 *  
 */
public class P896 {

    class Solution {
        public boolean isMonotonic(int[] A) {
            if (A.length <= 2) {
                return true;
            }
            int first = 0;
            for (int i = 1; i < A.length; ++i) {
                if (first == 0) {
                    first = A[i] - A[i - 1];
                } else if (!equasl(first, A[i] - A[i - 1])) {
                    return false;
                }
            }
            return true;
        }

        public boolean equasl(int x, int y) {
            if (x > 0 && y >= 0) {
                return true;
            } else if (x < 0 && y <= 0) {
                return true;
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isMonotonic(Arrs.build("[1,2,2,3]")));
        Assert.assertEquals(true, s.isMonotonic(Arrs.build("[6,5,4,4]")));
        Assert.assertEquals(false, s.isMonotonic(Arrs.build("[1,3,2]")));
        Assert.assertEquals(true, s.isMonotonic(Arrs.build("[1,2,4,5]")));
        Assert.assertEquals(true, s.isMonotonic(Arrs.build("[1,1,1]")));
    }

}
