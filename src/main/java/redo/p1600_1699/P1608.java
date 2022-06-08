package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1608  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1608 {

    static//

    class Solution {
        public int specialArray(int[] nums) {
            int[] count = count(nums, 0, 1001);
            int[] suffix = suffix(count);
            for (int i = 0; i <= 1000; ++i) {
                if (suffix[i] == i) {
                    return i;
                }
            }
            return -1;
        }

        public static int[] count(int[] nums, int start, int end) {
            int[] count = new int[end - start];
            for (int num : nums) {
                ++count[num - start];
            }
            return count;
        }

        public static int[] suffix(int[] nums) {
            int[] prefix = new int[nums.length + 1];
            for (int i = nums.length - 1; i >= 0; --i) {
                prefix[i] = prefix[i + 1] + nums[i];
            }
            return prefix;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.specialArray(new int[] {3, 5}));
        Assert.assertEquals(-1, s.specialArray(new int[] {0, 0}));
        Assert.assertEquals(3, s.specialArray(new int[] {0, 4, 3, 0, 4}));
        Assert.assertEquals(-1, s.specialArray(new int[] {3, 6, 7, 7, 0}));
    }

}
