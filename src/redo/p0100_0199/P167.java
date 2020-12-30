package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P167  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P167 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                if (numbers[low] + numbers[high] == target) {
                    return new int[] {low + 1, high + 1};
                } else if (numbers[low] + numbers[high] < target) {
                    ++low;
                } else {
                    --high;
                }
            }
            throw new RuntimeException("无答案");
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {1, 2}, s.twoSum(new int[] {2, 7, 11, 15}, 9));
    }

}
