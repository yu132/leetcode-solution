package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1566  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1566 {

    class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {

            outer:
            for (int i = 0; i < arr.length - k * m + 1; ++i) {
                for (int j = i + m; j < i + k * m; j += m) {
                    for (int x = 0; x < m; ++x) {
                        if (j + x >= arr.length || arr[i + x] != arr[j + x]) {
                            continue outer;
                        }
                    }
                }
                return true;
            }

            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.containsPattern(new int[] {1, 2, 4, 4, 4, 4}, 1, 3));
        Assert.assertEquals(true, s.containsPattern(new int[] {1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
        Assert.assertEquals(false, s.containsPattern(new int[] {1, 2, 1, 2, 1, 3}, 2, 3));
        Assert.assertEquals(false, s.containsPattern(new int[] {1, 2, 3, 1, 2}, 2, 2));
        Assert.assertEquals(false, s.containsPattern(new int[] {2, 2, 2, 2}, 2, 3));
        Assert.assertEquals(true, s.containsPattern(new int[] {1, 2, 1, 2}, 2, 2));
        Assert.assertEquals(true, s.containsPattern(new int[] {1, 1, 2, 1, 2}, 2, 2));
        Assert.assertEquals(true, s.containsPattern(new int[] {1}, 1, 1));
        Assert.assertEquals(true, s.containsPattern(new int[] {1, 1}, 1, 2));
    }

}
