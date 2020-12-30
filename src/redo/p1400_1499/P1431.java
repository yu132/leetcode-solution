package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1431  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1431 {

    static//

    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = max(candies);
            List<Boolean> ability = new ArrayList<>();
            for (int candie : candies) {
                ability.add(candie + extraCandies >= max);
            }
            return ability;
        }

        public static int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(true, true, true, false, true),
            s.kidsWithCandies(new int[] {2, 3, 5, 1, 3}, 3));
        Assert.assertEquals(Arrays.asList(true, false, false, false, false),
            s.kidsWithCandies(new int[] {4, 2, 1, 1, 2}, 1));
        Assert.assertEquals(Arrays.asList(true, false, true), s.kidsWithCandies(new int[] {12, 1, 12}, 10));
    }

}
