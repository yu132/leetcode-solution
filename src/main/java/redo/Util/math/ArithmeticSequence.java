package redo.Util.math;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;

/**  
 * @ClassName: ArithmeticSequence  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class ArithmeticSequence {

    public boolean isArithmeticSequence(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public int getSum(int a0, int n, int d) {
        return a0 * n + d * (n * n - n) / 2;
    }

    public int getSum(int n) {
        return (int)((long)n * (n + 1) / 2);
    }

    public int getMaxN(int sum) {
        return (int)(Math.sqrt(2 * sum + 0.25) - 0.5);
    }

    @Test
    public void test() {
        assertEquals(4, getMaxN(getSum(4)));
        assertEquals(12, getMaxN(getSum(12)));
        assertEquals(13453, getMaxN(getSum(13453)));
        assertEquals(13453, getMaxN(getSum(13453) + 1));
        assertEquals(13453, getMaxN(getSum(13453) + 13453));
        assertEquals(13454, getMaxN(getSum(13453) + 13454));
    }

    @Test
    public void test2() {
        assertEquals(1, getSum(1, 1, 2));
    }
}
