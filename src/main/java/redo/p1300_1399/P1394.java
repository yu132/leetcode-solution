package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1394  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1394 {

    class Solution {
        public int findLucky(int[] arr) {
            int[] feq = new int[501];
            for (int num : arr) {
                ++feq[num];
            }
            for (int i = 500; i >= 1; --i) {
                if (feq[i] == i) {
                    return i;
                }
            }
            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findLucky(new int[] {2, 2, 3, 4}));
        Assert.assertEquals(3, s.findLucky(new int[] {1, 2, 2, 3, 3, 3}));
        Assert.assertEquals(-1, s.findLucky(new int[] {2, 2, 2, 3, 3}));
        Assert.assertEquals(-1, s.findLucky(new int[] {5}));
        Assert.assertEquals(7, s.findLucky(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }

}
