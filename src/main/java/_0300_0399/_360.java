package _0300_0399;

import java.util.Arrays;

/**  
 * @ClassName: _360  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _360 {

    class Solution {
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

            if (a == 0) {
                if (b == 0) {
                    Arrays.fill(nums, c);
                    return nums;
                } else if (b > 0) {
                    for (int i = 0; i < nums.length; ++i) {
                        nums[i] = nums[i] * b + c;
                    }
                    return nums;
                } else {// b < 0
                    for (int i = 0; i < nums.length / 2; ++i) {
                        int temp = nums[i];
                        nums[i]                   = nums[nums.length - 1 - i] * b + c;
                        nums[nums.length - 1 - i] = temp * b + c;
                    }
                    if ((nums.length & 2) == 1) {
                        nums[nums.length / 2] = nums[nums.length / 2] * b + c;
                    }
                    return nums;
                }
            } else if (a > 0) {
                double mid = -(double)b / (2 * a);
                int[]  ans = new int[nums.length];
                int    low, high, index = lowerBound(nums, 0, nums.length, (int)mid);
                if (Double.compare(mid, nums[index]) <= 0) {
                    low  = index - 1;
                    high = index;
                } else {
                    low  = index;
                    high = index + 1;
                }
                index = 0;
                while (low >= 0 && high < nums.length) {
                    if (mid - nums[low] < nums[high] - mid) {
                        ans[index++] = nums[low] * nums[low] * a + nums[low] * b + c;
                        --low;
                    } else {
                        ans[index++] = nums[high] * nums[high] * a + nums[high] * b + c;
                        ++high;
                    }
                }
                while (low >= 0) {
                    ans[index++] = nums[low] * nums[low] * a + nums[low] * b + c;
                    --low;
                }
                while (high < nums.length) {
                    ans[index++] = nums[high] * nums[high] * a + nums[high] * b + c;
                    ++high;
                }
                return ans;
            } else {// a<0
                double mid = -(double)b / (2 * a);
                int[]  ans = new int[nums.length];
                int    low, high, index = lowerBound(nums, 0, nums.length, (int)mid);
                if (Double.compare(mid, nums[index]) <= 0) {
                    low  = index - 1;
                    high = index;
                } else {
                    low  = index;
                    high = index + 1;
                }
                index = nums.length - 1;
                while (low >= 0 && high < nums.length) {
                    if (mid - nums[low] < nums[high] - mid) {
                        ans[index--] = nums[low] * nums[low] * a + nums[low] * b + c;
                        --low;
                    } else {
                        ans[index--] = nums[high] * nums[high] * a + nums[high] * b + c;
                        ++high;
                    }
                }
                while (low >= 0) {
                    ans[index--] = nums[low] * nums[low] * a + nums[low] * b + c;
                    --low;
                }
                while (high < nums.length) {
                    ans[index--] = nums[high] * nums[high] * a + nums[high] * b + c;
                    ++high;
                }
                return ans;
            }

        }

        public int lowerBound(int[] array, int from, int size, int key) {
            int first = from, middle;
            int half, len;
            len = size;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (array[middle] < key) {
                    first = middle + 1;
                    len   = len - half - 1; // 在右边子序列中查找
                } else
                    len = half; // 在左边子序列（包含middle）中查找
            }
            return first;
        }
    }

    public static void main(String[] args) {
        new _360().new Solution().sortTransformedArray(new int[] {-4, -2, 2, 4}, -1, 3, 5);
    }
}
