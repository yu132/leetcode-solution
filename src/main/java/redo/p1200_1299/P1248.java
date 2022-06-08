package redo.p1200_1299;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1248  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1248 {

    static//

    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            List<Integer> list = new ArrayList<>(nums.length / 2);
            list.add(-1);

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] % 2 != 0) {
                    list.add(i);
                }
            }

            list.add(nums.length);

            int count = 0;

            for (int i = 1, j = k; j < list.size() - 1; ++i, ++j) {
                count += (list.get(i) - list.get(i - 1)) * (list.get(j + 1) - list.get(j));
            }

            return count;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.numberOfSubarrays(new int[] {1, 1, 2, 1, 1}, 3));
        Assert.assertEquals(0, s.numberOfSubarrays(new int[] {2, 4, 6}, 1));
        Assert.assertEquals(16, s.numberOfSubarrays(new int[] {2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

}
