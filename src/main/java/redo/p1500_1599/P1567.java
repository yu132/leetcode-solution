package redo.p1500_1599;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1567  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1567 {

    static//

    class Solution {
        public int getMaxLen(int[] nums) {
            List<Range> except0 = splitBy(0, nums);

            int maxLen = 0;

            for (Range range : except0) {
                int countNeg = countNeg(nums, range.start, range.end);

                if (countNeg % 2 == 0) {
                    maxLen = Math.max(maxLen, range.end - range.start);
                    continue;
                }

                int low = range.start, high = range.end - 1;

                while (nums[low] > 0) {
                    ++low;
                }

                while (nums[high] > 0) {
                    --high;
                }

                maxLen = Math.max(maxLen, Math.max(range.end - low - 1, high - range.start));
            }

            return maxLen;
        }

        public static int countNeg(int[] nums, int start, int end) {
            int neg = 0;
            for (int i = start; i < end; ++i) {
                if (nums[i] < 0) {
                    ++neg;
                }
            }
            return neg;
        }

        public List<Range> splitBy(int val, int[] nums) {
            List<Range> splitIndex = new ArrayList<>();
            int start = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == val) {
                    if (start == i) {
                        start = i + 1;
                        continue;
                    }
                    splitIndex.add(new Range(start, i));
                    start = i + 1;
                }
            }
            if (start != nums.length) {
                splitIndex.add(new Range(start, nums.length));
            }
            return splitIndex;
        }

        static class Range {
            int start;
            int end;

            Range(int start, int end) {
                super();
                this.start = start;
                this.end = end;
            }

            public boolean isValueInRange(int value) {
                return start <= value && value <= end;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.getMaxLen(new int[] {1, -2, -3, 4}));
        Assert.assertEquals(3, s.getMaxLen(new int[] {0, 1, -2, -3, -4}));
        Assert.assertEquals(2, s.getMaxLen(new int[] {-1, -2, -3, 0, 1}));
        Assert.assertEquals(1, s.getMaxLen(new int[] {-1, 2}));
        Assert.assertEquals(4, s.getMaxLen(new int[] {1, 2, 3, 5, -6, 4, 0, 10}));
        Assert.assertEquals(2, s.getMaxLen(new int[] {1000000000, 1000000000}));
        Assert.assertEquals(0, s.getMaxLen(new int[] {0, 0, 0, 0}));
        Assert.assertEquals(1, s.getMaxLen(new int[] {1}));
    }

}
