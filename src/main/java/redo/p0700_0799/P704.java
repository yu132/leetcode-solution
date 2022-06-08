package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P704  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P704 {

    class Solution {
        public int search(int[] nums, int target) {
            int insertIndex = lowerBound(nums, target, 0, nums.length);
            if (insertIndex == nums.length || nums[insertIndex] != target) {
                return -1;
            }
            return insertIndex;
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
        Assert.assertEquals(4, s.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        Assert.assertEquals(-1, s.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
    }

}
