package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1291  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1291 {

    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= 9; ++i) {
                ans.addAll(len(i, low, high));
            }
            return ans;
        }

        public List<Integer> len(int len, int low, int high) {
            int base = 0, inc = 0;
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= len; ++i) {
                base = base * 10 + i;
                inc = inc * 10 + 1;
            }
            if (low <= base && base <= high) {
                ans.add(base);
            }
            for (int i = len; i < 9; ++i) {
                base += inc;
                if (low <= base && base <= high) {
                    ans.add(base);
                }
            }
            return ans;
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(123, 234), s.sequentialDigits(100, 300));
        Assert.assertEquals(Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789, 12345), s.sequentialDigits(1000, 13000));
        Assert.assertEquals(Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345,
            3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678,
            3456789, 12345678, 23456789, 123456789), s.sequentialDigits(10, 1000000000));

    }

}
