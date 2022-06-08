package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1300  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1300 {

    static//

    class Solution {
        public int findBestValue(int[] arr, int target) {
            if (sum(arr) <= target) {
                return max(arr);
            }
            int low = target / arr.length, high = target;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (sum(arr, mid) >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int sum1 = sum(arr, low);
            int sum2 = sum(arr, low - 1);
            return target - sum2 <= sum1 - target ? low - 1 : low;
        }

        public static int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        public int sum(int[] arr) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            return sum;
        }

        public int sum(int[] arr, int max) {
            int sum = 0;
            for (int num : arr) {
                if (num > max) {
                    sum += max;
                } else {
                    sum += num;
                }
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.findBestValue(new int[] {4, 9, 3}, 10));
        Assert.assertEquals(5, s.findBestValue(new int[] {2, 3, 5}, 10));
        Assert.assertEquals(11361, s.findBestValue(new int[] {60864, 25176, 27249, 21296, 20204}, 56803));
        Assert.assertEquals(5, s.findBestValue(new int[] {2, 3, 5}, 11));
    }

}
