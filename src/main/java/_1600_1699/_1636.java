package _1600_1699;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**  
 * @ClassName: _1636  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月14日  
 *  
 */
public class _1636 {

    class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> feq = new HashMap<>(nums.length);
            for (int num : nums) {
                feq.put(num, feq.getOrDefault(num, 0) + 1);
            }
            Integer[] temp = new Integer[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                temp[i] = nums[i];
            }
            Arrays.sort(temp, (a, b) -> {
                if (feq.get(a) != feq.get(b)) {
                    return Integer.compare(feq.get(a), feq.get(b));
                }
                return Integer.compare(b, a);
            });
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = temp[i];
            }
            return nums;
        }
    }

    @Test
    public void test() {
        assertArrayEquals(new int[] {3, 1, 1, 2, 2, 2}, new Solution().frequencySort(new int[] {1, 1, 2, 2, 2, 3}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] {1, 3, 3, 2, 2}, new Solution().frequencySort(new int[] {2, 3, 1, 3, 2}));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] {5, -1, 4, 4, -6, -6, 1, 1, 1},
            new Solution().frequencySort(new int[] {-1, 1, -6, 4, 5, -6, 1, 4, 1}));
    }
}
