package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1299  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1299 {

    class Solution {
        public int[] replaceElements(int[] arr) {
            int max = -1;
            for (int i = arr.length - 1; i >= 0; --i) {
                int temp = arr[i];
                arr[i] = max;
                max = Math.max(max, temp);
            }
            return arr;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {18, 6, 6, 6, 1, -1}, s.replaceElements(new int[] {17, 18, 5, 4, 6, 1}));
    }

}
