package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P961  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P961 {

    class Solution {
        public int repeatedNTimes(int[] A) {
            if (A[0] == A[2]) {
                return A[0];
            } else if (A[1] == A[3]) {
                return A[1];
            } else if (A[0] == A[3]) {
                return A[0];
            }
            for (int i = 1; i < A.length; ++i) {
                if (A[i - 1] == A[i]) {
                    return A[i];
                }
            }
            throw new RuntimeException("unreachable");
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.repeatedNTimes(new int[] {1, 2, 3, 3}));
        Assert.assertEquals(2, s.repeatedNTimes(new int[] {2, 1, 2, 5, 3, 2}));
        Assert.assertEquals(5, s.repeatedNTimes(new int[] {5, 1, 5, 2, 5, 3, 5, 4}));
        Assert.assertEquals(9, s.repeatedNTimes(new int[] {9, 5, 6, 9}));
    }

}
