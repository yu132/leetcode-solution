package redo.p0400_0499;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * @ClassName: P492  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P492 {

    class Solution {
        public int[] constructRectangle(int area) {
            for (int i = (int)Math.sqrt(area); i >= 0; --i) {
                if (area % i == 0) {
                    return new int[] {area / i, i};
                }
            }
            throw new RuntimeException("unreachable");
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, 2}, s.constructRectangle(4));
        assertArrayEquals(new int[] {4, 4}, s.constructRectangle(16));
        assertArrayEquals(new int[] {5, 4}, s.constructRectangle(20));
        assertArrayEquals(new int[] {7, 4}, s.constructRectangle(28));
    }

}
