package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1545  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1545 {

    static//

    class Solution {

        private final static int[] LENS = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767,
            65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727,
            268435455, 536870911, 1073741823};

        public char findKthBit(int n, int k) {
            return helper(n, k - 1);
        }

        public char helper(int n, int k) {
            if (n == 1) {
                return '0';
            }

            int halfLen = LENS[n - 1] / 2;

            if (k == halfLen) {
                return '1';
            } else if (k < halfLen) {
                return helper(n - 1, k);
            } else {
                return invert(helper(n - 1, LENS[n - 1] - k - 1));
            }
        }

        public char invert(char ch) {
            if (ch == '1') {
                return '0';
            }
            return '1';
        }

        public int lowerBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals('0', s.findKthBit(3, 1));
        Assert.assertEquals('1', s.findKthBit(2, 3));
        Assert.assertEquals('1', s.findKthBit(4, 11));
        Assert.assertEquals('0', s.findKthBit(1, 1));
        Assert.assertEquals('1', s.findKthBit(2, 3));
        Assert.assertEquals('1', s.findKthBit(18, 123));
        Assert.assertEquals('0', s.findKthBit(18, 52428));
        // for (long i = 1; i < Integer.MAX_VALUE; i = 2 * i + 1) {
        // System.out.print(i + ",");
        // }
    }

}
