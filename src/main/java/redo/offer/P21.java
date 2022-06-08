package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P21  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P21 {

    class Solution {
        public int[] exchange(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                while (low < high && (nums[low] & 1) == 1) {
                    ++low;
                }
                while (low < high && (nums[high] & 1) == 0) {
                    --high;
                }
                if (low < high) {
                    int temp = nums[low];
                    nums[low] = nums[high];
                    nums[high] = temp;
                }
            }
            return nums;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 3, 2, 4},
            s.exchange(new int[] {1, 2, 3, 4}));
    }

}
