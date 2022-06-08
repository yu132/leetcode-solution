package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1403  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1403 {

    static//

    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            List<Integer> ans = new ArrayList<>(nums.length / 2);
            Arrays.sort(nums);
            int sum = sum(nums), now = 0;
            for (int i = nums.length - 1; i >= 0; --i) {
                now += nums[i];
                sum -= nums[i];
                ans.add(nums[i]);
                if (now > sum) {
                    break;
                }
            }
            return ans;
        }

        public static int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(10, 9), s.minSubsequence(new int[] {4, 3, 10, 9, 8}));
        Assert.assertEquals(Arrays.asList(7, 7, 6), s.minSubsequence(new int[] {4, 4, 7, 6, 7}));
        Assert.assertEquals(Arrays.asList(6), s.minSubsequence(new int[] {6}));
    }

}
