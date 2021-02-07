package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P03 {

    class Solution {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                int val = nums[i];
                nums[i] = -1;
                while (val != -1) {
                    if (nums[val] == val) {
                        return val;
                    }
                    int temp = nums[val];
                    nums[val] = val;
                    val = temp;
                }
            }
            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2,
            s.findRepeatNumber(new int[] {2, 3, 1, 0, 2, 5, 3}));
    }

}
