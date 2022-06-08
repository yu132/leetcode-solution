package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P303  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P303 {

    class NumArray {

        private int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefixSum[i + 1] = nums[i] + prefixSum[i];
            }
        }

        public int sumRange(int i, int j) {
            return prefixSum[j + 1] - prefixSum[i];
        }
    }

    @Test
    public void test() {
        NumArray a = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        assertEquals(1, a.sumRange(0, 2));
        assertEquals(-1, a.sumRange(2, 5));
        assertEquals(-3, a.sumRange(0, 5));
    }


}
