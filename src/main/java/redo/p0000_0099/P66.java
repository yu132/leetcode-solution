package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P66  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P66 {

    class Solution {
        public int[] plusOne(int[] digits) {
            int inc = 1;
            for (int i = digits.length - 1; i >= 0; --i) {
                digits[i] += inc;
                if (digits[i] == 10) {// 还要继续进位
                    digits[i] = 0;
                    continue;
                }
                return digits;// 没有更多的进位，就直接返回了
            }

            // 由于还有进位，因此需要在前面再追加一位1
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            System.arraycopy(digits, 0, newArr, 1, digits.length);
            return newArr;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 2, 4}, s.plusOne(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {4, 3, 2, 2}, s.plusOne(new int[] {4, 3, 2, 1}));
        assertArrayEquals(new int[] {2, 0, 0}, s.plusOne(new int[] {1, 9, 9}));
        assertArrayEquals(new int[] {1, 0, 0, 0}, s.plusOne(new int[] {9, 9, 9}));
    }
}
