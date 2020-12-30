package redo.Util.math;

import static org.junit.jupiter.api.Assertions.*;

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
}
