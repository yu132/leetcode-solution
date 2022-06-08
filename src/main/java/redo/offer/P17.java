package redo.offer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P17  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P17 {

    class Solution {
        public int[] printNumbers(int n) {
            int[] nums = new int[(int)Math.pow(10, n) - 1];
            Arrays.setAll(nums, (x) -> x + 1);
            return nums;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9},
            s.printNumbers(1));
    }

}
