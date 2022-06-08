package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P836  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P836 {

    class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return in(rec1[0], rec1[2], rec2[0], rec2[2]) && in(rec1[1], rec1[3], rec2[1], rec2[3])
                && notArea0(rec1[0], rec1[1], rec1[2], rec1[3]) && notArea0(rec2[0], rec2[1], rec2[2], rec2[3]);
        }

        private boolean in(int a1, int a2, int b1, int b2) {
            return a1 < b2 && b1 < a2;
        }

        private boolean notArea0(int a1, int a2, int b1, int b2) {
            return a1 != b1 && a2 != b2;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isRectangleOverlap(new int[] {0, 0, 2, 2}, new int[] {1, 1, 3, 3}));
        Assert.assertEquals(false, s.isRectangleOverlap(new int[] {0, 0, 1, 1}, new int[] {1, 0, 2, 1}));
        Assert.assertEquals(false, s.isRectangleOverlap(new int[] {0, 0, 1, 1}, new int[] {2, 2, 3, 3}));
        Assert.assertEquals(true, s.isRectangleOverlap(new int[] {0, 0, 1, 1}, new int[] {0, 0, 1, 1}));
        Assert.assertEquals(false, s.isRectangleOverlap(new int[] {-1, 0, 1, 1}, new int[] {0, -1, 0, 1}));


    }

}
