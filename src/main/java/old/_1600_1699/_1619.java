package old._1600_1699;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**  
 * @ClassName: _1619  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月14日  
 *  
 */
public class _1619 {
    class Solution {
        public double trimMean(int[] arr) {
            Arrays.sort(arr);
            int _5PerNum = (int)(arr.length * 0.05);
            int sum = 0;
            for (int i = _5PerNum; i < arr.length - _5PerNum; ++i) {
                sum += arr[i];
            }
            return sum * 1.0 / (arr.length - _5PerNum * 2);
        }
    }

    @Test
    public void test() {
        assertEquals(2.0,
            new Solution().trimMean(new int[] {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
    }

    @Test
    public void test2() {
        assertEquals(5.29167,
            new Solution().trimMean(new int[] {4, 8, 4, 10, 0, 7, 1, 3, 7, 8, 8, 3, 4, 1, 6, 2, 1, 1, 8, 0, 9, 8, 0, 3,
                9, 10, 3, 10, 1, 10, 7, 3, 2, 1, 4, 9, 10, 7, 6, 4, 0, 8, 5, 1, 2, 1, 6, 2, 5, 0, 7, 10, 9, 10, 3, 7,
                10, 5, 8, 5, 7, 6, 7, 6, 10, 9, 5, 10, 5, 5, 7, 2, 10, 7, 7, 8, 2, 0, 1, 1}),
            0.00001);

    }
}
