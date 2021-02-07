package redo.p0000_0099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P34  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P34 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int lower = lowerBound(nums, target),
                upper = upperBound(nums, target);
            if (lower == upper) {
                return new int[] {-1, -1};
            }
            return new int[] {lower, upper - 1};
        }

        public int lowerBound(int[] nums, int target) {
            int low = 0, high = nums.length;
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

        public int upperBound(int[] nums, int target) {
            int low = 0, high = nums.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] <= target) {
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
        Assert.assertArrayEquals(new int[] {3, 4},
            s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));

        Assert.assertArrayEquals(new int[] {-1, -1},
            s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));

        Assert.assertArrayEquals(new int[] {-1, -1},
            s.searchRange(new int[] {}, 0));
    }

}
