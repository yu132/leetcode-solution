package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P645  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P645 {

    class Solution {
        public int[] findErrorNums(int[] nums) {
            for (int i = 1; i <= nums.length; ++i) {
                while (nums[i - 1] != i && nums[nums[i - 1] - 1] != nums[i - 1]) {
                    int temp = nums[nums[i - 1] - 1];
                    nums[nums[i - 1] - 1] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }

            for (int i = 1; i <= nums.length; ++i) {
                if (nums[i - 1] != i) {
                    return new int[] {nums[i - 1], i};
                }
            }

            throw new RuntimeException("unreachable");
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 3}, s.findErrorNums(new int[] {1, 2, 2, 4}));
    }

}
